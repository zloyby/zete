package by.zloy.epg

import groovy.time.TimeCategory

class Parser {
    public static void main(String[] args) {
        // HOWTO: compile and run by:
        // groovyc -cp groovy-all-2.4.1.jar Parser.groovy
        // java -cp groovy-all-2.4.1.jar:. Parser /Users/eugene/Desktop/epg-generate-day.xml 5 5 1000 9999-Oxagile

        def to = new File(args[0])
        //'1501-NRK1', '17001-NRK1', '1039-NRK1 HD', '3515-NRK1 HD'
        //'205-MTV', '2607-MTV (S)', '2934-MTV3 HD', '4901-MTV MAX HD'
        def minutesLength = Integer.parseInt(args[1])
        def minutesBetween = Integer.parseInt(args[2])
        def iterations = Integer.parseInt(args[3])
        def array = [args[4]]

        generate(to, array, iterations, minutesLength, minutesBetween)
    }

    static void generate(def file, def array, def iterations, def minutesLength, def minutesBetween) {
        file << "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        file << "<!-- Created by TSReader from COOLSTF.com -->"
        file << "<tv generator-info-name=\"TSReader\">"

        final def FORMAT_EPG_TIMEZONE = "yyyyMMddHHmmss Z"
        def id = 1500000000

        array.each {

            def name = it.substring(it.indexOf('-') + 1)
            file << """
            <channel id="${it}">
                <display-name lang="en">${name}</display-name>
                <transport-stream-ID>35</transport-stream-ID>
                <signal-info>1.0W 11.372 V 24500 7/8 QPSK, DVB-S</signal-info>
            </channel>"""

            def now = new Date()
            def next = new Date()
            now.seconds = 0
            next.seconds = 0
            use(TimeCategory) {
                now = now - 3.hour
                next = now + minutesLength.minute
            }

            for (int i = 0; i < iterations; i++) {

                use(TimeCategory) {
                    now = now + minutesLength.minute + minutesBetween.minute
                    next = next + minutesLength.minute + minutesBetween.minute
                }

                String datetime1 = now.format(FORMAT_EPG_TIMEZONE)
                String datetime2 = next.format(FORMAT_EPG_TIMEZONE)
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
