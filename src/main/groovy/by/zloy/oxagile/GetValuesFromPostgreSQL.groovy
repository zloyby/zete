package by.zloy.oxagile

import groovy.sql.Sql

class GetValuesFromPostgreSQL {
    static def dbUrl = "jdbc:postgresql://192.168.32.30:5432/dbtest"
    static def dbUser = "test_user"
    static def dbPassword = "qwerty@1"
    static def dbDriver = "org.postgresql.Driver"

    static def version = "?api=v2"
    static def file = new File("/Users/eugene/Desktop/ValuesFromPostgreSQL.txt")

    public static void main(String[] args) {
        def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)

        def query = "select * from attachments where contenttype like 'application/vnd.openxmlformats%' or contenttype like 'application/pdf%'"
        sql.eachRow query, { attachments ->
            file << ("https://wiki.oxagile.com/download/attachments/${attachments.pageid}/${attachments.title}${version}\n")
        }
    }
}
