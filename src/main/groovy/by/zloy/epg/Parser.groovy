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
        file << """
        <channel id="1501-NRK1">
            <display-name lang="en">NRK1</display-name>
            <transport-stream-ID>35</transport-stream-ID>
            <signal-info>1.0W 11.372 V 24500 7/8 QPSK, DVB-S</signal-info>
        </channel>"""

        def id = 1501220735
        def now = new Date()
        def now1m = new Date()

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
            <programme start="${datetime1}" stop="${datetime2}" channel="1501-NRK1" id="${id}">
                <title>Landgang ${i}/${id}</title>
                <desc>(Ep. ${i}/${id}).  I ei lita sirkusvogn lagar Anne mat saman med Katarina Cule til artistar frå elleve land.</desc>
                <rating system="MPAA">
                <value>G</value>
                </rating>
            </programme>"""
        }

        file << "</tv>"

    }
}
