package by.zloy.apps.csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import by.zloy.utils.PropertiesUtil;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class CvsChanger {
    public static void main(String[] args) throws IOException {
        CSVReader readerColumns = new CSVReader(new FileReader(PropertiesUtil.loadCsv("csv/DstColumn.csv")));
        CSVReader readerTypes = new CSVReader(new FileReader(PropertiesUtil.loadCsv("csv/DstType.csv")));
        List<DstColumn> listColumns = parseColumns(readerColumns);
        List<DstType> listTypes = parseTypes(readerTypes);
        changeValues(listColumns, listTypes);
        writeToFile(listColumns);
    }

    private static void changeValues(List<DstColumn> listColumns, List<DstType> listTypes) {
        for (DstColumn column : listColumns) {
            if (!column.system.equals("1")) {
                String DSTName = column.DSTName;
                String DSTColumnName = column.DSTColumnName;

                if (DSTName.equalsIgnoreCase("Account Activity") && DSTColumnName.equalsIgnoreCase("Transaction Reference")) {
                    //do nothing by VOY-2827
                } else {
                    for (DstType listType : listTypes) {
                        if (listType.name.equalsIgnoreCase(DSTName)) {
                            String columnNames = listType.identifying_dst_column_names;
                            StringTokenizer st = new StringTokenizer(columnNames, ",");
                            while (st.hasMoreTokens()) {
                                String s = st.nextToken();
                                if (s.equalsIgnoreCase(DSTColumnName)) {
                                    column.Mandatory = "1";
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //DST ID,DST: DST Name,DST Column ID,DST Column Name,Data Type,Definition,Column Order,Is Name,Mandatory,Size,Min Value,Max Value,Lookup,List of Values Name,Submission Column,dst_column_group_id,data_warehouse_column_name,system,data_warehouse_column_id,primary
    private static List<DstColumn> parseColumns(CSVReader readerColumns) {
        ColumnPositionMappingStrategy<DstColumn> mapperDstColumn = new ColumnPositionMappingStrategy<DstColumn>();
        mapperDstColumn.setType(DstColumn.class);
        String[] columns = new String[]{
                "DSTID", "DSTName", "DSTColumnID", "DSTColumnName", "DataType",
                "Definition", "ColumnOrder", "IsName", "Mandatory", "Size", "MinValue", "MaxValue", "Lookup",
                "ListofValuesName", "SubmissionColumn", "dst_column_group_id", "data_warehouse_column_name",
                "system", "data_warehouse_column_id", "primary"
        };
        mapperDstColumn.setColumnMapping(columns);
        CsvToBean<DstColumn> csvColumn = new CsvToBean<DstColumn>();
        return csvColumn.parse(mapperDstColumn, readerColumns);
    }

    //name,dst_type_id,priority,submission_table,has_photo,top_level,parent_id,data_warehouse_table,identifying_dst_column_names
    private static List<DstType> parseTypes(CSVReader readerTypes) {
        ColumnPositionMappingStrategy<DstType> mapperDstType = new ColumnPositionMappingStrategy<DstType>();
        mapperDstType.setType(DstType.class);
        String[] types = new String[]{
                "name", "dst_type_id", "priority", "submission_table", "has_photo",
                "top_level", "parent_id", "data_warehouse_table", "identifying_dst_column_names"
        };
        mapperDstType.setColumnMapping(types);
        CsvToBean<DstType> csvType = new CsvToBean<DstType>();
        return csvType.parse(mapperDstType, readerTypes);
    }

    private static void writeToFile(List<DstColumn> listColumns) throws IOException {
        File nc = new File("/Users/eugene/workspace/zloy/zete/src/main/resources/csv/DstColumn_NEW2.csv");
        MyCSVWriter writerColumns = new MyCSVWriter(new FileWriter(nc), ',', CSVWriter.NO_QUOTE_CHARACTER);
        for (DstColumn column : listColumns) {
            writerColumns.writeNext(column.getAll());
        }
        writerColumns.close();
    }

    public static class MyCSVWriter implements Closeable {
        public static final int INITIAL_STRING_SIZE = 128;
        /**
         * The character used for escaping quotes.
         */
        public static final char DEFAULT_ESCAPE_CHARACTER = '"';
        /**
         * The default quote character to use if none is supplied to the
         * constructor.
         */
        public static final char DEFAULT_QUOTE_CHARACTER = '"';
        /**
         * The quote constant to use when you wish to suppress all quoting.
         */
        public static final char NO_QUOTE_CHARACTER = '\u0000';
        /**
         * The escape constant to use when you wish to suppress all escaping.
         */
        public static final char NO_ESCAPE_CHARACTER = '\u0000';
        /**
         * Default line terminator uses platform encoding.
         */
        public static final String DEFAULT_LINE_END = "\n";
        private Writer rawWriter;
        private PrintWriter pw;
        private char separator;
        private char quotechar;
        private char escapechar;
        private String lineEnd;

        /**
         * Constructs CSVWriter with supplied separator and quote char.
         *
         * @param writer    the writer to an underlying CSV source.
         * @param separator the delimiter to use for separating entries
         * @param quotechar the character to use for quoted elements
         */
        public MyCSVWriter(Writer writer, char separator, char quotechar) {
            this(writer, separator, quotechar, DEFAULT_ESCAPE_CHARACTER);
        }

        /**
         * Constructs CSVWriter with supplied separator and quote char.
         *
         * @param writer     the writer to an underlying CSV source.
         * @param separator  the delimiter to use for separating entries
         * @param quotechar  the character to use for quoted elements
         * @param escapechar the character to use for escaping quotechars or escapechars
         */
        public MyCSVWriter(Writer writer, char separator, char quotechar, char escapechar) {
            this(writer, separator, quotechar, escapechar, DEFAULT_LINE_END);
        }

        /**
         * Constructs CSVWriter with supplied separator, quote char, escape char and line ending.
         *
         * @param writer     the writer to an underlying CSV source.
         * @param separator  the delimiter to use for separating entries
         * @param quotechar  the character to use for quoted elements
         * @param escapechar the character to use for escaping quotechars or escapechars
         * @param lineEnd    the line feed terminator to use
         */
        public MyCSVWriter(Writer writer, char separator, char quotechar, char escapechar, String lineEnd) {
            this.rawWriter = writer;
            this.pw = new PrintWriter(writer);
            this.separator = separator;
            this.quotechar = quotechar;
            this.escapechar = escapechar;
            this.lineEnd = lineEnd;
        }

        /**
         * Writes the next line to the file.
         *
         * @param nextLine a string array with each comma-separated element as a separate
         *                 entry.
         */
        public void writeNext(String[] nextLine) {

            if (nextLine == null)
                return;

            StringBuilder sb = new StringBuilder(INITIAL_STRING_SIZE);
            for (int i = 0; i < nextLine.length; i++) {

                if (i != 0) {
                    sb.append(separator);
                }

                String nextElement = nextLine[i];
                if (nextElement == null)
                    continue;
                if (quotechar != NO_QUOTE_CHARACTER)
                    sb.append(quotechar);

                sb.append(nextElement.contains(",") ? DEFAULT_QUOTE_CHARACTER : "");
                sb.append(stringContainsSpecialCharacters(nextElement) ? processLine(nextElement) : nextElement);
                sb.append(nextElement.contains(",") ? DEFAULT_QUOTE_CHARACTER : "");

                if (quotechar != NO_QUOTE_CHARACTER)
                    sb.append(quotechar);
            }

            sb.append(lineEnd);
            pw.write(sb.toString());

        }

        private boolean stringContainsSpecialCharacters(String line) {
            return line.indexOf(quotechar) != -1 || line.indexOf(escapechar) != -1;
        }

        protected StringBuilder processLine(String nextElement) {
            StringBuilder sb = new StringBuilder(INITIAL_STRING_SIZE);
            for (int j = 0; j < nextElement.length(); j++) {
                char nextChar = nextElement.charAt(j);
                if (escapechar != NO_ESCAPE_CHARACTER && nextChar == quotechar) {
                    sb.append(escapechar).append(nextChar);
                } else if (escapechar != NO_ESCAPE_CHARACTER && nextChar == escapechar) {
                    sb.append(escapechar).append(nextChar);
                } else {
                    sb.append(nextChar);
                }
            }

            return sb;
        }

        /**
         * Flush underlying stream to writer.
         *
         * @throws IOException if bad things happen
         */
        public void flush() throws IOException {

            pw.flush();

        }

        /**
         * Close the underlying stream writer flushing any buffered content.
         *
         * @throws IOException if bad things happen
         */
        public void close() throws IOException {
            flush();
            pw.close();
            rawWriter.close();
        }
    }
}
