package by.zloy.apps.csv;

public class DstType {
    public String name;
    public String dst_type_id;
    public String priority;
    public String submission_table;
    public String has_photo;
    public String top_level;
    public String parent_id;
    public String data_warehouse_table;
    public String identifying_dst_column_names;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDst_type_id() {
        return dst_type_id;
    }

    public void setDst_type_id(String dst_type_id) {
        this.dst_type_id = dst_type_id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSubmission_table() {
        return submission_table;
    }

    public void setSubmission_table(String submission_table) {
        this.submission_table = submission_table;
    }

    public String getHas_photo() {
        return has_photo;
    }

    public void setHas_photo(String has_photo) {
        this.has_photo = has_photo;
    }

    public String getTop_level() {
        return top_level;
    }

    public void setTop_level(String top_level) {
        this.top_level = top_level;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getData_warehouse_table() {
        return data_warehouse_table;
    }

    public void setData_warehouse_table(String data_warehouse_table) {
        this.data_warehouse_table = data_warehouse_table;
    }

    public String getIdentifying_dst_column_names() {
        return identifying_dst_column_names;
    }

    public void setIdentifying_dst_column_names(String identifying_dst_column_names) {
        this.identifying_dst_column_names = identifying_dst_column_names;
    }
}
