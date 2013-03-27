package by.zloy.csv;

public class DstColumn {
    public String DSTID;
    public String DSTName;
    public String DSTColumnID;
    public String DSTColumnName;
    public String DataType;
    public String Definition;
    public String ColumnOrder;
    public String IsName;
    public String Mandatory;
    public String Size;
    public String MinValue;
    public String MaxValue;
    public String Lookup;
    public String ListofValuesName;
    public String SubmissionColumn;
    public String dst_column_group_id;
    public String data_warehouse_column_name;
    public String system;
    public String data_warehouse_column_id;
    public String primary;

    public String[] getAll() {
        return new String[]{DSTID, DSTName, DSTColumnID, DSTColumnName, DataType, Definition, ColumnOrder, IsName, Mandatory, Size, MinValue, MaxValue, Lookup, ListofValuesName, SubmissionColumn, dst_column_group_id, data_warehouse_column_name, system, data_warehouse_column_id, primary};
    }

    public String getDSTID() {
        return DSTID;
    }

    public void setDSTID(String DSTID) {
        this.DSTID = DSTID;
    }

    public String getDSTName() {
        return DSTName;
    }

    public void setDSTName(String DSTName) {
        this.DSTName = DSTName;
    }

    public String getDSTColumnID() {
        return DSTColumnID;
    }

    public void setDSTColumnID(String DSTColumnID) {
        this.DSTColumnID = DSTColumnID;
    }

    public String getDSTColumnName() {
        return DSTColumnName;
    }

    public void setDSTColumnName(String DSTColumnName) {
        this.DSTColumnName = DSTColumnName;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public String getDefinition() {
        return Definition;
    }

    public void setDefinition(String definition) {
        Definition = definition;
    }

    public String getColumnOrder() {
        return ColumnOrder;
    }

    public void setColumnOrder(String columnOrder) {
        ColumnOrder = columnOrder;
    }

    public String getIsName() {
        return IsName;
    }

    public void setIsName(String isName) {
        IsName = isName;
    }

    public String getMandatory() {
        return Mandatory;
    }

    public void setMandatory(String mandatory) {
        Mandatory = mandatory;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getMinValue() {
        return MinValue;
    }

    public void setMinValue(String minValue) {
        MinValue = minValue;
    }

    public String getMaxValue() {
        return MaxValue;
    }

    public void setMaxValue(String maxValue) {
        MaxValue = maxValue;
    }

    public String getLookup() {
        return Lookup;
    }

    public void setLookup(String lookup) {
        Lookup = lookup;
    }

    public String getListofValuesName() {
        return ListofValuesName;
    }

    public void setListofValuesName(String listofValuesName) {
        ListofValuesName = listofValuesName;
    }

    public String getSubmissionColumn() {
        return SubmissionColumn;
    }

    public void setSubmissionColumn(String submissionColumn) {
        SubmissionColumn = submissionColumn;
    }

    public String getDst_column_group_id() {
        return dst_column_group_id;
    }

    public void setDst_column_group_id(String dst_column_group_id) {
        this.dst_column_group_id = dst_column_group_id;
    }

    public String getData_warehouse_column_name() {
        return data_warehouse_column_name;
    }

    public void setData_warehouse_column_name(String data_warehouse_column_name) {
        this.data_warehouse_column_name = data_warehouse_column_name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getData_warehouse_column_id() {
        return data_warehouse_column_id;
    }

    public void setData_warehouse_column_id(String data_warehouse_column_id) {
        this.data_warehouse_column_id = data_warehouse_column_id;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }
}
