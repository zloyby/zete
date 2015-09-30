package by.zloy.epg

import groovy.time.TimeCategory

class Parser {
    public static void main(String[] args) {

        File to = new File('/Users/eugene/Desktop/epg-generate-day.xml')
        generate(to)
    }

    public static final String FORMAT_EPG_TIMEZONE = "yyyyMMddHHmmss Z"

    static void generate(File file) {
        file << "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        file << "<!-- Created by TSReader from COOLSTF.com -->"
        file << "<tv generator-info-name=\"TSReader\">"

        //'1501-NRK1', '17001-NRK1', '1039-NRK1 HD', '3515-NRK1 HD'
        //'205-MTV', '2607-MTV (S)', '2934-MTV3 HD', '4901-MTV MAX HD'

        def id = 1501220735
        def array = ['1501-NRK1']
        array.each {

            def name = it.substring(it.indexOf('-') + 1)
            file << """
            <channel id="${it}">
                <display-name lang="en">${name}</display-name>
                <transport-stream-ID>35</transport-stream-ID>
                <signal-info>1.0W 11.372 V 24500 7/8 QPSK, DVB-S</signal-info>
            </channel>"""


            def now = new Date()
            def now1m = new Date()

            now.seconds = 0
            now1m.seconds = 0

            use(TimeCategory) {
                now = now - 3.hour
                now1m = now + 1.minute
            }

            for (int i = 0; i < 24 * 60; i++) {

                use(TimeCategory) {
                    now = now + 1.minute
                    now1m = now1m + 1.minute
                }

                String datetime1 = now.format(FORMAT_EPG_TIMEZONE)
                String datetime2 = now1m.format(FORMAT_EPG_TIMEZONE)
                id = id + 10

                file << """
            <programme start="${datetime1}" stop="${datetime2}" channel="${it}" id="${id}">
                <title>Landgang ${i}/${id}</title>
                <desc>(Ep. ${i}/${id}).  I ei lita sirkusvogn lagar Anne mat saman med Katarina Cule til artistar frå elleve land.</desc>
                <rating system="MPAA">
                <value>G</value>
                </rating>
            </programme>"""
            }
        }



        file << "</tv>"

    }
}
