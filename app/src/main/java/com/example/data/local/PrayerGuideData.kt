package com.example.data.local

import com.example.data.model.PrayerGuideCategory
import com.example.data.model.PrayerGuideItem
import com.example.data.model.PrayerRole
import com.example.data.model.PrayerTimeType

/**
 * Data Panduan Shalat 5 Waktu Lengkap.
 * Referensi resmi: Mozaik Inilah.com (https://mozaik.inilah.com/ibadah/bacaan-sholat-5-waktu-lengkap)
 * Disusun bersama Prodi Tadris Fisika UIN Syarif Hidayatullah Jakarta.
 */
object PrayerGuideData {

    const val REFERENCE_URL = "https://mozaik.inilah.com/ibadah/bacaan-sholat-5-waktu-lengkap"
    const val REFERENCE_NAME = "Mozaik Islam Inilah.com"

    val items: List<PrayerGuideItem> = listOf(
        // ==================== SYARAT & RUKUN SHALAT ====================
        PrayerGuideItem(
            id = "sr_1",
            category = PrayerGuideCategory.SYARAT_RUKUN,
            title = "Syarat Wajib Shalat",
            subtitle = "Kriteria yang mewajibkan seseorang menunaikan shalat fardhu",
            arabic = "شُرُوطُ وُجُوبِ الصَّلَاةِ",
            latin = "Syuruuthu Wujuubish Shalaah",
            translation = "1. Beragama Islam (Muslim/Muslimah)\n2. Baligh (mencapai usia dewasa secara biologis atau syar'i)\n3. Berakal sehat (tidak gila/hilang akal)\n4. Suci dari haid dan nifas bagi wanita\n5. Telah sampai seruan/dakwah Islam kepadanya\n6. Terjaga (tidak sedang tertidur lelap)",
            explanation = "Shalat fardhu 5 waktu adalah rukun Islam kedua yang menjadi tiang agama. Orang yang memenuhi syarat wajib di atas berdosa besar jika meninggalkan shalat dengan sengaja.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "sr_2",
            category = PrayerGuideCategory.SYARAT_RUKUN,
            title = "Syarat Sah Shalat",
            subtitle = "Hal-hal yang harus terpenuhi sebelum memulai shalat agar sah",
            arabic = "شُرُوطُ صِحَّةِ الصَّلَاةِ",
            latin = "Syuruuthu Shihhatish Shalaah",
            translation = "1. Suci dari hadas kecil (berwudhu) dan hadas besar (mandi wajib)\n2. Suci badan, pakaian, dan tempat shalat dari najis\n3. Menutup aurat dengan sempurna (laki-laki dari pusar sampai lutut, wanita seluruh tubuh kecuali wajah dan kedua telapak tangan)\n4. Mengetahui masuknya waktu shalat (bisa dibantu jadwal hisab/offline app ini)\n5. Menghadap ke arah kiblat (Ka'bah di Makkah Al-Mukarramah)",
            explanation = "Jika salah satu syarat sah tidak terpenuhi tanpa uzur syar'i, shalat menjadi batal atau tidak sah dan wajib diulangi.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "sr_3",
            category = PrayerGuideCategory.SYARAT_RUKUN,
            title = "Rukun Shalat (13 Perkara)",
            subtitle = "Bagian inti shalat yang wajib dilakukan secara berurutan",
            arabic = "أَرْكَانُ الصَّلَاةِ ثَلَاثَةَ عَشَرَ",
            latin = "Arkaanush Shalaah Tsalaatsata 'Asyara",
            translation = "1. Niat di dalam hati bersamaan dengan takbir\n2. Berdiri bagi yang mampu (qiyam)\n3. Takbiratul Ihram ('Allahu Akbar')\n4. Membaca Surat Al-Fatihah dengan tartil\n5. Rukuk dengan tuma'ninah (tenang sejenak)\n6. I'tidal dengan tuma'ninah\n7. Sujud dua kali dengan tuma'ninah\n8. Duduk di antara dua sujud dengan tuma'ninah\n9. Duduk pada tasyahud akhir\n10. Membaca bacaan tasyahud akhir\n11. Membaca shalawat atas Nabi SAW pada tasyahud akhir\n12. Mengucapkan salam yang pertama\n13. Tertib (melakukan rukun secara berurutan)",
            explanation = "Tuma'ninah artinya diam tenang sejenak seukuran membaca 'Subhanallah'. Tuma'ninah wajib pada rukuk, i'tidal, sujud, dan duduk di antara dua sujud.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),

        // ==================== NIAT SHALAT 5 WAKTU ====================
        // --- SUBUH ---
        PrayerGuideItem(
            id = "niat_subuh_munfarid",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Subuh - Sendiri (Munfarid)",
            subtitle = "Shalat fardhu 2 rakaat di waktu fajar shadiq",
            prayerTime = PrayerTimeType.SUBUH,
            role = PrayerRole.MUNFARID,
            rakaat = 2,
            arabic = "أُصَلِّى فَرْضَ الصُّبْحِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhash-shubhi rak'ataini mustaqbilal qiblati adaa'an lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Subuh dua rakaat menghadap kiblat secara tunai karena Allah Ta'ala.",
            explanation = "Niat dilafalkan dalam hati berbarengan saat mengucap Takbiratul Ihram. Melafalkan secara lisan sebelum takbir hukumnya sunnah menurut madzhab Syafi'i untuk memantapkan hati.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_subuh_makmum",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Subuh - Makmum",
            subtitle = "Shalat fardhu Subuh berjamaah sebagai makmum",
            prayerTime = PrayerTimeType.SUBUH,
            role = PrayerRole.MAKMUM,
            rakaat = 2,
            arabic = "أُصَلِّى فَرْضَ الصُّبْحِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ مَأْمُوْمًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhash-shubhi rak'ataini mustaqbilal qiblati ma'muuman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Subuh dua rakaat menghadap kiblat sebagai makmum karena Allah Ta'ala.",
            explanation = "Makmum wajib mengikuti imam dalam gerakan shalat dan tidak mendahuluinya.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_subuh_imam",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Subuh - Imam",
            subtitle = "Shalat fardhu Subuh berjamaah memimpin sebagai imam",
            prayerTime = PrayerTimeType.SUBUH,
            role = PrayerRole.IMAM,
            rakaat = 2,
            arabic = "أُصَلِّى فَرْضَ الصُّبْحِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ إِمَامًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhash-shubhi rak'ataini mustaqbilal qiblati imaaman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Subuh dua rakaat menghadap kiblat sebagai imam karena Allah Ta'ala.",
            explanation = "Imam membaca jahr (lantang) pada surat Al-Fatihah dan ayat Al-Qur'an di rakaat pertama dan kedua.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),

        // --- DZUHUR ---
        PrayerGuideItem(
            id = "niat_dzuhur_munfarid",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Dzuhur - Sendiri (Munfarid)",
            subtitle = "Shalat fardhu 4 rakaat saat matahari tergelincir",
            prayerTime = PrayerTimeType.DZUHUR,
            role = PrayerRole.MUNFARID,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الظُّهْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhazh-zhuhri arba'a raka'aatim mustaqbilal qiblati adaa'an lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Dzuhur empat rakaat menghadap kiblat secara tunai karena Allah Ta'ala.",
            explanation = "Shalat Dzuhur bacaannya dibaca sirr (lirih) di setiap rakaat.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_dzuhur_makmum",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Dzuhur - Makmum",
            subtitle = "Shalat fardhu Dzuhur berjamaah sebagai makmum",
            prayerTime = PrayerTimeType.DZUHUR,
            role = PrayerRole.MAKMUM,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الظُّهْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَأْمُوْمًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhazh-zhuhri arba'a raka'aatim mustaqbilal qiblati ma'muuman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Dzuhur empat rakaat menghadap kiblat sebagai makmum karena Allah Ta'ala.",
            explanation = "Makmum berniat mengikuti imam shalat Dzuhur 4 rakaat.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_dzuhur_imam",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Dzuhur - Imam",
            subtitle = "Shalat fardhu Dzuhur memimpin sebagai imam",
            prayerTime = PrayerTimeType.DZUHUR,
            role = PrayerRole.IMAM,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الظُّهْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ إِمَامًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhazh-zhuhri arba'a raka'aatim mustaqbilal qiblati imaaman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Dzuhur empat rakaat menghadap kiblat sebagai imam karena Allah Ta'ala.",
            explanation = "Imam melirihkan bacaan Al-Fatihah dan surat pendek (sirr).",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),

        // --- ASHAR ---
        PrayerGuideItem(
            id = "niat_ashar_munfarid",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Ashar - Sendiri (Munfarid)",
            subtitle = "Shalat fardhu 4 rakaat di waktu sore",
            prayerTime = PrayerTimeType.ASHAR,
            role = PrayerRole.MUNFARID,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الْعَصْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal 'ashri arba'a raka'aatim mustaqbilal qiblati adaa'an lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Ashar empat rakaat menghadap kiblat secara tunai karena Allah Ta'ala.",
            explanation = "Shalat Ashar adalah Shalat Wustha yang sangat dijaga keutamaannya dalam hadits shahih.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_ashar_makmum",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Ashar - Makmum",
            subtitle = "Shalat fardhu Ashar berjamaah sebagai makmum",
            prayerTime = PrayerTimeType.ASHAR,
            role = PrayerRole.MAKMUM,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الْعَصْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَأْمُوْمًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal 'ashri arba'a raka'aatim mustaqbilal qiblati ma'muuman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Ashar empat rakaat menghadap kiblat sebagai makmum karena Allah Ta'ala.",
            explanation = "Semua bacaan rakaat dibaca sirr (lirih).",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_ashar_imam",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Ashar - Imam",
            subtitle = "Shalat fardhu Ashar memimpin sebagai imam",
            prayerTime = PrayerTimeType.ASHAR,
            role = PrayerRole.IMAM,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الْعَصْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ إِمَامًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal 'ashri arba'a raka'aatim mustaqbilal qiblati imaaman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Ashar empat rakaat menghadap kiblat sebagai imam karena Allah Ta'ala.",
            explanation = "Imam memimpin shalat Ashar berjamaah 4 rakaat.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),

        // --- MAGHRIB ---
        PrayerGuideItem(
            id = "niat_maghrib_munfarid",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Maghrib - Sendiri (Munfarid)",
            subtitle = "Shalat fardhu 3 rakaat setelah matahari terbenam",
            prayerTime = PrayerTimeType.MAGHRIB,
            role = PrayerRole.MUNFARID,
            rakaat = 3,
            arabic = "أُصَلِّى فَرْضَ الْمَغْرِبِ ثَلَاثَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal maghribi tsalaatsa raka'aatim mustaqbilal qiblati adaa'an lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Maghrib tiga rakaat menghadap kiblat secara tunai karena Allah Ta'ala.",
            explanation = "Terdiri dari 3 rakaat dengan tasyahud awal di rakaat ke-2 dan tasyahud akhir di rakaat ke-3.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_maghrib_makmum",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Maghrib - Makmum",
            subtitle = "Shalat fardhu Maghrib berjamaah sebagai makmum",
            prayerTime = PrayerTimeType.MAGHRIB,
            role = PrayerRole.MAKMUM,
            rakaat = 3,
            arabic = "أُصَلِّى فَرْضَ الْمَغْرِبِ ثَلَاثَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَأْمُوْمًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal maghribi tsalaatsa raka'aatim mustaqbilal qiblati ma'muuman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Maghrib tiga rakaat menghadap kiblat sebagai makmum karena Allah Ta'ala.",
            explanation = "Mendengarkan bacaan jahran imam di rakaat 1 dan 2, lalu membaca Al-Fatihah masing-masing.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_maghrib_imam",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Maghrib - Imam",
            subtitle = "Shalat fardhu Maghrib memimpin sebagai imam",
            prayerTime = PrayerTimeType.MAGHRIB,
            role = PrayerRole.IMAM,
            rakaat = 3,
            arabic = "أُصَلِّى فَرْضَ الْمَغْرِبِ ثَلَاثَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ إِمَامًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal maghribi tsalaatsa raka'aatim mustaqbilal qiblati imaaman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Maghrib tiga rakaat menghadap kiblat sebagai imam karena Allah Ta'ala.",
            explanation = "Imam membaca keras (jahr) Al-Fatihah dan surat di rakaat 1 dan 2, serta lirih di rakaat 3.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),

        // --- ISYA ---
        PrayerGuideItem(
            id = "niat_isya_munfarid",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Isya - Sendiri (Munfarid)",
            subtitle = "Shalat fardhu 4 rakaat saat mega merah menghilang",
            prayerTime = PrayerTimeType.ISYA,
            role = PrayerRole.MUNFARID,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الْعِشَاءِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal 'isyaa'i arba'a raka'aatim mustaqbilal qiblati adaa'an lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Isya empat rakaat menghadap kiblat secara tunai karena Allah Ta'ala.",
            explanation = "Waktu shalat Isya berlangsung sampai terbit fajar shadiq (menjelang Subuh).",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_isya_makmum",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Isya - Makmum",
            subtitle = "Shalat fardhu Isya berjamaah sebagai makmum",
            prayerTime = PrayerTimeType.ISYA,
            role = PrayerRole.MAKMUM,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الْعِشَاءِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَأْمُوْمًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal 'isyaa'i arba'a raka'aatim mustaqbilal qiblati ma'muuman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Isya empat rakaat menghadap kiblat sebagai makmum karena Allah Ta'ala.",
            explanation = "Makmum menyimak bacaan jahr imam di rakaat 1 dan 2.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "niat_isya_imam",
            category = PrayerGuideCategory.NIAT_5_WAKTU,
            title = "Niat Shalat Isya - Imam",
            subtitle = "Shalat fardhu Isya memimpin sebagai imam",
            prayerTime = PrayerTimeType.ISYA,
            role = PrayerRole.IMAM,
            rakaat = 4,
            arabic = "أُصَلِّى فَرْضَ الْعِشَاءِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ إِمَامًا لِلَّهِ تَعَالَى",
            latin = "Ushallii fardhal 'isyaa'i arba'a raka'aatim mustaqbilal qiblati imaaman lillaahi ta'aalaa.",
            translation = "Aku niat shalat fardhu Isya empat rakaat menghadap kiblat sebagai imam karena Allah Ta'ala.",
            explanation = "Imam membaca jahr di rakaat 1 & 2, dan sirr di rakaat 3 & 4.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),

        // ==================== TATA CARA GERAKAN & BACAAN SHALAT ====================
        PrayerGuideItem(
            id = "gerak_1",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 1,
            title = "1. Berdiri Tegak & Berniat",
            subtitle = "Posisi qiyam menghadap arah kiblat",
            arabic = "القِيَامُ مَعَ النِّيَّةِ",
            latin = "Al-Qiyaamu ma'an-niyyah",
            translation = "Berdiri tegak menghadap kiblat, pandangan tertuju ke tempat sujud, hati berniat ikhlas karena Allah SWT.",
            explanation = "Bagi yang tidak mampu berdiri karena sakit atau udzur fisik, diperbolehkan shalat dengan duduk, atau berbaring ke sisi kanan, atau terlentang.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_2",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 2,
            title = "2. Takbiratul Ihram",
            subtitle = "Mengangkat kedua tangan sejajar telinga/bahu",
            arabic = "اللهُ أَكْبَرُ",
            latin = "Allaahu Akbar",
            translation = "Allah Maha Besar.",
            explanation = "Kedua tangan diangkat sejajar pundak atau daun telinga dengan jari-jari direnggangkan wajar menghadap kiblat, lalu didekapkan di atas dada (tangan kanan di atas pergelangan tangan kiri).",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_3",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 3,
            title = "3. Membaca Doa Iftitah",
            subtitle = "Dibaca setelah takbiratul ihram sebelum membaca Al-Fatihah",
            arabic = "اللهُ أَكْبَرُ كَبِيْرًا وَالْحَمْدُ لِلَّهِ كَثِيْرًا وَسُبْحَانَ اللَّهِ بُكْرَةً وَأَصِيْلًا. إِنِّى وَجَّهْتُ وَجْهِيَ لِلَّذِي فَطَرَ السَّمَاوَاتِ وَالأَرْضَ حَنِيفًا مُسْلِمًا وَمَا أَنَا مِنَ الْمُشْرِكِينَ. إِنَّ صَلاَتِي وَنُسُكِي وَمَحْيَايَ وَمَمَاتِي لِلَّهِ رَبِّ الْعَالَمِينَ. لاَ شَرِيكَ لَهُ وَبِذَلِكَ أُمِرْتُ وَأَنَا مِنَ الْمُسْلِمِينَ",
            latin = "Allaahu akbaru kabiiraa wal hamdu lillaahi katsiiraa wa subhaanallaahi bukrataw wa ashiilaa. Innii wajjahtu wajhiya lilladzii fatharas-samaawaati wal ardha haniifam muslimaw wamaa anaa minal musyrikiin. Inna shalaatii wa nusukii wa mahyaaya wa mamaatii lillaahi rabbil 'aalamiin. Laa syariika lahu wa bidzaalika umirtu wa anaa minal muslimiin.",
            translation = "Allah Maha Besar dengan sebesar-besarnya, segala puji yang banyak bagi Allah, Maha Suci Allah sepanjang pagi dan petang. Sesungguhnya aku hadapkan wajahku kepada Dzat yang menciptakan langit dan bumi dengan lurus dan berserah diri, dan aku bukanlah dari golongan orang-orang musyrik. Sesungguhnya shalatku, ibadahku, hidupku, dan matiku semata-mata kepunyaan Allah Rabb semesta alam. Tiada sekutu bagi-Nya, dan dengan itulah aku diperintahkan, dan aku termasuk golongan orang-orang yang berserah diri.",
            explanation = "Membaca doa iftitah hukumnya sunnah muakkadah pada rakaat pertama. Jika tertinggal karena makmum masbuq, shalat tetap sah.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_4",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 4,
            title = "4. Membaca Surat Al-Fatihah",
            subtitle = "Rukun wajib di setiap rakaat shalat",
            arabic = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ (١) الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِينَ (٢) الرَّحْمَٰنِ الرَّحِيمِ (٣) مَالِكِ يَوْمِ الدِّينِ (٤) إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ (٥) اهْدِنَا الصِّرَاطَ الْمُسْتَقِيمَ (٦) صِرَاطَ الَّذِينَ أَنْعَمْتَ عَلَيْهِمْ غَيْرِ الْمَغْضُوبِ عَلَيْهِمْ وَلَا الضَّالِّينَ (٧)",
            latin = "1. Bismillaahir-rahmaanir-rahiim.\n2. Alhamdu lillaahi rabbil 'aalamiin.\n3. Ar-rahmaanir-rahiim.\n4. Maaliki yaumid-diin.\n5. Iyyaaka na'budu wa iyyaaka nasta'iin.\n6. Ihdinash-shiraathal mustaqiim.\n7. Shiraathalladziina an'amta 'alaihim ghairil maghdhuubi 'alaihim waladh-dhaalliin. (Aamiin)",
            translation = "1. Dengan nama Allah Yang Maha Pengasih lagi Maha Penyayang.\n2. Segala puji bagi Allah, Rabb semesta alam.\n3. Maha Pengasih lagi Maha Penyayang.\n4. Pemilik hari pembalasan.\n5. Hanya kepada Engkaulah kami menyembah dan hanya kepada Engkaulah kami memohon pertolongan.\n6. Tunjukilah kami jalan yang lurus.\n7. (Yaitu) jalan orang-orang yang telah Engkau beri nikmat kepada mereka; bukan (jalan) mereka yang dimurkai dan bukan (pula jalan) mereka yang sesat. (Kabulkanlah doa kami ya Allah).",
            explanation = "Rasulullah SAW bersabda: 'Tidak sah shalat bagi orang yang tidak membaca Fatihatul Kitab (Al-Fatihah).' (HR. Bukhari & Muslim).",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_5",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 5,
            title = "5. Membaca Surat Pendek Al-Qur'an",
            subtitle = "Sunnah dibaca setelah Al-Fatihah pada rakaat 1 dan 2",
            arabic = "قُلْ هُوَ اللَّهُ أَحَدٌ (١) اللَّهُ الصَّمَدُ (٢) لَمْ يَلِدْ وَلَمْ يُولَدْ (٣) وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ (٤)",
            latin = "Qul huwallaahu ahad (1). Allaahush-shamad (2). Lam yalid wa lam yuulad (3). Wa lam yakul lahu kufuwan ahad (4).",
            translation = "1. Katakanlah: Dialah Allah, Yang Maha Esa.\n2. Allah adalah tempat bergantung segala sesuatu.\n3. Dia tidak beranak dan tidak pula diperanakkan.\n4. Dan tidak ada seorang pun yang setara dengan Dia.",
            explanation = "Boleh membaca surat Al-Ikhlas, Al-Falaq, An-Nas, atau surat-surat lain dari Al-Qur'an.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_6",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 6,
            title = "6. Gerakan Rukuk & Tuma'ninah",
            subtitle = "Membungkuk punggung lurus dan membaca tasbih rukuk 3x",
            arabic = "سُبْحَانَ رَبِّيَ الْعَظِيْمِ وَبِحَمْدِهِ",
            latin = "Subhaana rabbiyal 'azhiimi wa bihamdih. (Dibaca 3 kali)",
            translation = "Maha Suci Rabbku Yang Maha Agung dan dengan memuji kepada-Nya.",
            explanation = "Saat rukuk, punggung dan leher diposisikan sejajar lurus, kedua telapak tangan memegang lutut dengan jari-jari terbuka, serta tuma'ninah (berhenti tenang sejenak).",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_7",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 7,
            title = "7. Bangkit I'tidal & Tuma'ninah",
            subtitle = "Bangkit dari rukuk mengangkat kedua tangan lalu bersedekap/lurus",
            arabic = "سَمِعَ اللَّهُ لِمَنْ حَمِدَهُ\nرَبَّنَا لَكَ الْحَمْدُ مِلْءَ السَّمَاوَاتِ وَمِلْءَ الأَرْضِ وَمِلْءَ مَا شِئْتَ مِنْ شَيْءٍ بَعْدُ",
            latin = "Saat bangkit: Sami'allaahu liman hamidah.\nSaat tegak: Rabbanaa lakal hamdu mil'us-samaawaati wa mil'ul ardhi wa mil'u maa syi'ta min syai'in ba'd.",
            translation = "Saat bangkit: 'Allah mendengar orang yang memuji-Nya.'\nSaat tegak: 'Wahai Rabb kami, bagi-Mu segala puji sepenuh langit dan sepenuh bumi serta sepenuh apa saja yang Engkau kehendaki sesudah itu.'",
            explanation = "Berdiri tegak lurus sejenak dengan tuma'ninah sebelum turun menuju sujud.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_8",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 8,
            title = "8. Gerakan Sujud Pertama & Tuma'ninah",
            subtitle = "Menempelkan 7 anggota sujud ke lantai dan membaca tasbih sujud 3x",
            arabic = "سُبْحَانَ رَبِّيَ الأَعْلَى وَبِحَمْدِهِ",
            latin = "Subhaana rabbiyal a'laa wa bihamdih. (Dibaca 3 kali)",
            translation = "Maha Suci Rabbku Yang Maha Tinggi dan dengan memuji kepada-Nya.",
            explanation = "Tujuh anggota badan yang wajib menempel ke tempat sujud: dahi (termasuk hidung), kedua telapak tangan, kedua lutut, dan ujung jari-jari kedua kaki.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_9",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 9,
            title = "9. Duduk di Antara Dua Sujud (Duduk Iftirasy)",
            subtitle = "Duduk di atas kaki kiri dan menegakkan kaki kanan",
            arabic = "رَبِّ اغْفِرْ لِي وَارْحَمْنِي وَاجْبُرْنِي وَارْفَعْنِي وَارْزُقْنِي وَاهْدِنِي وَعَافِنِي وَاعْفُ عَنِّي",
            latin = "Rabbighfir lii warhamnii wajburnii warfa'nii warzuqnii wahdinii wa 'aafinii wa'fu 'annii.",
            translation = "Wahai Rabbku, ampunilah dosaku, kasihanilah aku, cukupkanlah kekuranganku, angkatlah derajatku, karuniakanlah rezeki kepadaku, berilah aku petunjuk, sehatkanlah afiatku, dan maafkanlah kesalahanku.",
            explanation = "Duduk dengan tenang (tuma'ninah), kedua tangan diletakkan di atas paha dekat lutut.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_10",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 10,
            title = "10. Sujud Kedua & Tuma'ninah",
            subtitle = "Mengulang sujud dengan tuma'ninah dan tasbih 3x",
            arabic = "سُبْحَانَ رَبِّيَ الأَعْلَى وَبِحَمْدِهِ",
            latin = "Subhaana rabbiyal a'laa wa bihamdih. (Dibaca 3 kali)",
            translation = "Maha Suci Rabbku Yang Maha Tinggi dan dengan memuji kepada-Nya.",
            explanation = "Setelah sujud kedua selesai, bangkit berdiri untuk mengerjakan rakaat berikutnya atau duduk untuk tasyahud.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_11",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 11,
            title = "11. Tasyahud Awal (Tahiyat Awal)",
            subtitle = "Dikerjakan pada rakaat ke-2 (untuk shalat Dzuhur, Ashar, Maghrib, Isya)",
            arabic = "التَّحِيَّاتُ الْمُبَارَكَاتُ الصَّلَوَاتُ الطَّيِّبَاتُ لِلَّهِ، السَّلَامُ عَلَيْكَ أَيُّهَا النَّبِيُّ وَرَحْمَةُ اللَّهِ وَبَرَكَاتُهُ، السَّلَامُ عَلَيْنَا وَعَلَى عِبَادِ اللَّهِ الصَّالِحِينَ، أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا اللَّهُ وَأَشْهَدُ أَنَّ مُحَمَّدًا رَسُولُ اللَّهِ. اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ",
            latin = "Attahiyyaatul mubaarakaatush-shalawaatuth-thayyibaatu lillaah. Assalaamu 'alaika ayyuhan-nabiyyu wa rahmatullaahi wa barakaatuh. Assalaamu 'alainaa wa 'alaa 'ibaadillaahish-shaalihiin. Asyhadu allaa ilaaha illallaah, wa asyhadu anna Muhammadar rasuulullaah. Allaahumma shalli 'alaa sayyidinaa Muhammad.",
            translation = "Segala kehormatan, keberkahan, kebahagiaan dan kebaikan itu kepunyaan Allah. Keselamatan atasmu wahai Nabi, beserta rahmat Allah dan berkah-Nya. Keselamatan atas kami dan atas sekalian hamba-hamba Allah yang saleh. Aku bersaksi bahwasanya tiada tuhan selain Allah dan aku bersaksi bahwasanya Nabi Muhammad adalah utusan Allah. Ya Allah limpahkanlah rahmat kepada junjungan kami Nabi Muhammad.",
            explanation = "Duduk dengan posisi iftirasy (menduduki kaki kiri dan menegakkan kaki kanan), jari telunjuk kanan diangkat saat membaca kalimat syahadat ('illallaah').",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_12",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 12,
            title = "12. Tasyahud Akhir & Shalawat Ibrahimiyyah",
            subtitle = "Rukun wajib di rakaat terakhir dengan duduk tawarruk",
            arabic = "التَّحِيَّاتُ الْمُبَارَكَاتُ الصَّلَوَاتُ الطَّيِّبَاتُ لِلَّهِ، السَّلَامُ عَلَيْكَ أَيُّهَا النَّبِيُّ وَرَحْمَةُ اللَّهِ وَبَرَكَاتُهُ، السَّلَامُ عَلَيْنَا وَعَلَى عِبَادِ اللَّهِ الصَّالِحِينَ، أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا اللَّهُ وَأَشْهَدُ أَنَّ مُحَمَّدًا رَسُولُ اللَّهِ.\nاللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِ سَيِّدِنَا مُحَمَّدٍ، كَمَا صَلَّيْتَ عَلَى سَيِّدِنَا إِبْرَاهِيمَ وَعَلَى آلِ سَيِّدِنَا إِبْرَاهِيمَ، وَبَارِكْ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِ سَيِّدِنَا مُحَمَّدٍ، كَمَا بَارَكْتَ عَلَى سَيِّدِنَا إِبْرَاهِيمَ وَعَلَى آلِ سَيِّدِنَا إِبْرَاهِيمَ، فِي الْعَالَمِينَ إِنَّكَ حَمِيدٌ مَجِيدٌ",
            latin = "Attahiyyaatul mubaarakaatush-shalawaatuth-thayyibaatu lillaah. Assalaamu 'alaika ayyuhan-nabiyyu wa rahmatullaahi wa barakaatuh. Assalaamu 'alainaa wa 'alaa 'ibaadillaahish-shaalihiin. Asyhadu allaa ilaaha illallaah, wa asyhadu anna Muhammadar rasuulullaah.\nAllaahumma shalli 'alaa sayyidinaa Muhammad, wa 'alaa aali sayyidinaa Muhammad, kamaa shallaita 'alaa sayyidinaa Ibraahiim, wa 'alaa aali sayyidinaa Ibraahiim. Wa baarik 'alaa sayyidinaa Muhammad, wa 'alaa aali sayyidinaa Muhammad, kamaa baarakta 'alaa sayyidinaa Ibraahiim, wa 'alaa aali sayyidinaa Ibraahiim, fil 'aalamiina innaka hamiidum majiid.",
            translation = "Segala kehormatan, keberkahan, kebahagiaan dan kebaikan itu kepunyaan Allah. Keselamatan atasmu wahai Nabi, beserta rahmat Allah dan berkah-Nya. Keselamatan atas kami dan atas sekalian hamba-hamba Allah yang saleh. Aku bersaksi bahwasanya tiada tuhan selain Allah dan aku bersaksi bahwasanya Nabi Muhammad adalah utusan Allah.\nYa Allah, limpahkanlah rahmat kepada junjungan kami Nabi Muhammad dan kepada keluarga junjungan kami Nabi Muhammad, sebagaimana Engkau telah melimpahkan rahmat kepada junjungan kami Nabi Ibrahim dan keluarga junjungan kami Nabi Ibrahim. Dan berkahilah junjungan kami Nabi Muhammad dan keluarga junjungan kami Nabi Muhammad, sebagaimana Engkau telah memberkahi junjungan kami Nabi Ibrahim dan keluarga junjungan kami Nabi Ibrahim. Di seluruh alam semesta, sesungguhnya Engkau Maha Terpuji lagi Maha Mulia.",
            explanation = "Duduk tawarruk: pantat menempel ke lantai, kaki kiri dimasukkan ke bawah kaki kanan, dan kaki kanan ditegakkan.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_13",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 13,
            title = "13. Doa Sebelum Salam",
            subtitle = "Sunnah memohon perlindungan dari 4 perkara sebelum mengucap salam",
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ عَذَابِ جَهَنَّمَ، وَمِنْ عَذَابِ الْقَبْرِ، وَمِنْ فِتْنَةِ الْمَحْيَا وَالْمَمَاتِ، وَمِنْ شَرِّ فِتْنَةِ الْمَسِيحِ الدَّجَّالِ",
            latin = "Allaahumma innii a'uudzu bika min 'adzaabi jahannama, wa min 'adzaabil qabri, wa min fitnatil mahyaa wal mamaati, wa min syarri fitnatil masiihid-dajjaal.",
            translation = "Ya Allah, sesungguhnya aku berlindung kepada-Mu dari azab neraka Jahannam, dari azab kubur, dari fitnah kehidupan dan kematian, serta dari keburukan fitnah Al-Masih Ad-Dajjal.",
            explanation = "Dianjurkan dibaca setelah selesai membaca shalawat tasyahud akhir sebelum menolehkan wajah untuk salam.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "gerak_14",
            category = PrayerGuideCategory.TATA_CARA,
            stepNumber = 14,
            title = "14. Salam Pertama & Kedua",
            subtitle = "Penutup shalat menoleh ke kanan lalu ke kiri",
            arabic = "السَّلَامُ عَلَيْكُمْ وَرَحْمَةُ اللَّهِ",
            latin = "Assalaamu 'alaikum wa rahmatullaah.",
            translation = "Semoga keselamatan dan rahmat Allah tercurah kepadamu.",
            explanation = "Salam pertama menoleh ke arah kanan hingga pipi terlihat dari belakang (rukun shalat). Salam kedua menoleh ke arah kiri (sunnah). Dengan salam ini ibadah shalat telah purna secara sah.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),

        // ==================== DZIKIR & DOA SESUDAH SHALAT ====================
        PrayerGuideItem(
            id = "dzikir_sholat_1",
            category = PrayerGuideCategory.DZIKIR_SESUDAH,
            stepNumber = 1,
            title = "Istighfar Sesudah Shalat (3x)",
            subtitle = "Memohon ampunan Allah setelah menyelesaikan shalat",
            arabic = "أَسْتَغْفِرُ اللَّهَ الْعَظِيمَ الَّذِي لَا إِلَهَ إِلَّا هُوَ الْحَيَّ الْقَيُّومَ وَأَتُوبُ إِلَيْهِ",
            latin = "Astaghfirullaahal 'azhiimal-ladzii laa ilaaha illaa huwal hayyul qayyuumu wa atuubu ilaih. (Dibaca 3 kali)",
            translation = "Aku memohon ampunan kepada Allah Yang Maha Agung, yang tiada tuhan selain Dia, Yang Maha Hidup lagi terus menerus mengurus makhluk-Nya, dan aku bertobat kepada-Nya.",
            explanation = "Rasulullah SAW sesudah salam beristighfar tiga kali dan mengagungkan nama Allah.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "dzikir_sholat_2",
            category = PrayerGuideCategory.DZIKIR_SESUDAH,
            stepNumber = 2,
            title = "Doa Keselamatan & Keberkahan",
            subtitle = "Mengakui sumber keselamatan berasal dari Allah",
            arabic = "اللَّهُمَّ أَنْتَ السَّلَامُ وَمِنْكَ السَّلَامُ تَبَارَكْتَ يَا ذَا الْجَلَالِ وَالإِكْرَامِ",
            latin = "Allaahumma antas-salaamu wa minkas-salaamu tabaarakta yaa dzal jalaali wal ikraam.",
            translation = "Ya Allah, Engkaulah Dzat yang memberi keselamatan, dan dari-Mulah keselamatan, Maha Berkah Engkau wahai Dzat yang memiliki Keagungan dan Kemuliaan.",
            explanation = "Hadits shahih riwayat Muslim No. 591.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "dzikir_sholat_3",
            category = PrayerGuideCategory.DZIKIR_SESUDAH,
            stepNumber = 3,
            title = "Tahlil & Penyerahan Kekuasaan",
            subtitle = "Pujian ketauhidan mutlak hanya bagi Allah SWT",
            arabic = "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ يُحْيِي وَيُمِيتُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ. اللَّهُمَّ لَا مَانِعَ لِمَا أَعْطَيْتَ، وَلَا مُعْطِيَ لِمَا مَنَعْتَ، وَلَا يَنْفَعُ ذَا الْجَدِّ مِنْكَ الْجَدُّ",
            latin = "Laa ilaaha illallaahu wahdahu laa syariika lah, lahul mulku wa lahul hamdu yuhyii wa yumiitu wa huwa 'alaa kulli syai'in qadiir. Allaahumma laa maani'a limaa a'thaita, wa laa mu'thiya limaa mana'ta, wa laa yanfa'u dzal jaddi minkal jaddu.",
            translation = "Tiada sesembahan yang berhak disembah selain Allah Yang Maha Esa, tiada sekutu bagi-Nya. Bagi-Nya kerajaan dan bagi-Nya segala puji, Dia Yang Menghidupkan dan Mematikan, dan Dia Maha Kuasa atas segala sesuatu. Ya Allah, tidak ada yang dapat menghalangi apa yang Engkau berikan, dan tidak ada yang dapat memberi apa yang Engkau cegah, dan tidak bermanfaat kekayaan orang yang kaya dari siksa-Mu.",
            explanation = "Hadits riwayat Bukhari No. 844 dan Muslim No. 593.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "dzikir_sholat_4",
            category = PrayerGuideCategory.DZIKIR_SESUDAH,
            stepNumber = 4,
            title = "Membaca Ayat Kursi (QS. Al-Baqarah: 255)",
            subtitle = "Jaminan surga bagi yang membacanya seusai shalat fardhu",
            arabic = "اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ۚ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ ۚ لَّهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ ۗ مَن ذَا الَّذِي يَشْفَعُ عِندَهُ إِلَّا بِإِذْنِهِ ۚ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ ۖ وَلَا يُحِيطُونَ بِشَيْءٍ مِّنْ عِلْمِهِ إِلَّا بِمَا شَاءَ ۚ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ ۖ وَلَا يَئُودُهُ حِفْظُهُمَا ۚ وَهُوَ الْعَلِيُّ الْعَظِيمُ",
            latin = "Allaahu laa ilaaha illaa huwal hayyul qayyuum, laa ta'khudzuhuu sinatuw-wa laa naum, lahuu maa fis-samaawaati wa maa fil ardh, man dzal-ladzii yasyfa'u 'indahuu illaa bi-idznih, ya'lamu maa baina aidiihim wa maa khalfahum, wa laa yuhiithuuna bisyai'im min 'ilmihii illaa bimaa syaa', wasi'a kursiyyuhus-samaawaati wal ardh, wa laa ya'uuduhuu hifzhuhumaa wa huwal 'aliyyul 'azhiim.",
            translation = "Allah, tidak ada tuhan selain Dia. Yang Maha Hidup, yang terus-menerus mengurus (makhluk-Nya), tidak mengantuk dan tidak tidur. Milik-Nya apa yang ada di langit dan apa yang ada di bumi. Tidak ada yang dapat memberi syafaat di sisi-Nya tanpa izin-Nya. Dia mengetahui apa yang di hadapan mereka dan apa yang di belakang mereka, dan mereka tidak mengetahui sesuatu apa pun tentang ilmu-Nya melainkan apa yang Dia kehendaki. Kursi-Nya meliputi langit dan bumi. Dan Dia tidak merasa berat memelihara keduanya, dan Dia Maha Tinggi, Maha Besar.",
            explanation = "Rasulullah SAW bersabda: 'Barangsiapa membaca Ayat Kursi sehabis setiap shalat fardhu, tiada yang menghalanginya masuk surga melainkan kematian.' (HR. An-Nasa'i).",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "dzikir_sholat_5",
            category = PrayerGuideCategory.DZIKIR_SESUDAH,
            stepNumber = 5,
            title = "Tasbih, Tahmid, Takbir (33x)",
            subtitle = "Pujian tasbih penyucian dosa",
            arabic = "سُبْحَانَ اللَّهِ (٣٣x)\nالْحَمْدُ لِلَّهِ (٣٣x)\nاللهُ أَكْبَرُ (٣٣x)",
            latin = "• Subhaanallaah (33 kali)\n• Alhamdulillaah (33 kali)\n• Allaahu Akbar (33 kali)",
            translation = "• Maha Suci Allah (33 kali)\n• Segala puji bagi Allah (33 kali)\n• Allah Maha Besar (33 kali)",
            explanation = "Dilengkapi menjadi 100 dengan mengucapkan tahlil: 'Laa ilaaha illallaahu wahdahu laa syariika lah, lahul mulku wa lahul hamdu wa huwa 'alaa kulli syai'in qadiir'.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        ),
        PrayerGuideItem(
            id = "dzikir_sholat_6",
            category = PrayerGuideCategory.DZIKIR_SESUDAH,
            stepNumber = 6,
            title = "Doa Lengkap Sesudah Shalat Fardhu",
            subtitle = "Memohon ampunan, pertolongan ibadah, dan keselamatan dunia akhirat",
            arabic = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ. الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِينَ حَمْدًا يُوَافِي نِعَمَهُ وَيُكَافِئُ مَزِيدَهُ. يَا رَبَّنَا لَكَ الْحَمْدُ كَمَا يَنْبَغِي لِجَلَالِ وَجْهِكَ وَلِعَظِيمِ سُلْطَانِكَ. اللَّهُمَّ صَلِّ وَسَلِّمْ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِ سَيِّدِنَا مُحَمَّدٍ. اللَّهُمَّ أَعِنَّا عَلَى ذِكْرِكَ وَشُكْرِكَ وَحُسْنِ عِبَادَتِكَ. رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
            latin = "Bismillaahir-rahmaanir-rahiim. Alhamdu lillaahi rabbil 'aalamiin, hamday-yuwaafii ni'amahuu wa yukaafi'u maziidah. Yaa rabbanaa lakal hamdu kamaa yambaghii lijalaali wajhika wa li'azhiimi sulthaanik. Allaahumma shalli wa sallim 'alaa sayyidinaa Muhammadin wa 'alaa aali sayyidinaa Muhammad. Allaahumma a'innaa 'alaa dzikrika wa syukrika wa husni 'ibaadatik. Rabbanaa aatinaa fid-dunyaa hasanataw wa fil aakhirati hasanataw wa qinaa 'adzaaban-naar.",
            translation = "Dengan nama Allah Yang Maha Pengasih lagi Maha Penyayang. Segala puji bagi Allah Rabb semesta alam, pujian yang sebanding dengan nikmat-nikmat-Nya dan menjamin tambahannya. Wahai Rabb kami, bagi-Mu segala puji sebagaimana layaknya bagi keagungan wajah-Mu dan kebesaran kekuasaan-Mu. Ya Allah limpahkanlah shalawat dan salam kepada junjungan kami Nabi Muhammad beserta keluarganya. Ya Allah, tolonglah kami untuk senantiasa mengingat-Mu, bersyukur kepada-Mu, dan beribadah dengan sebaik-baiknya kepada-Mu. Wahai Rabb kami, karuniakanlah kepada kami kebaikan di dunia dan kebaikan di akhirat, serta lindungilah kami dari siksa api neraka.",
            explanation = "Dianjurkan mengangkat kedua tangan saat berdoa dengan penuh kekhusyukan dan kerendahan hati.",
            sourceUrl = REFERENCE_URL,
            sourceName = REFERENCE_NAME
        )
    )
}
