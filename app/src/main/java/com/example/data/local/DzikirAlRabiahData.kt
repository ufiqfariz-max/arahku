package com.example.data.local

import com.example.data.model.DzikirItem
import com.example.data.model.DzikirType

/**
 * Panduan lengkap bacaan Dzikir Pagi, Dzikir Petang, dan Dzikir Sebelum Tidur
 * yang disusun berdasarkan riwayat shahih Al-Qur'an dan As-Sunnah An-Nabawiyyah.
 */
object DzikirData {

    val dzikirList = listOf(
        // ==========================================
        // DZIKIR PAGI (alrabiauinjkt.id/blog/detail/1115/dzikir-pagi)
        // ==========================================
        DzikirItem(
            id = 101,
            type = DzikirType.PAGI,
            title = "Membaca Ayat Kursi",
            arabic = "اللَّهُ لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ وَلَا يَئُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ",
            latin = "Allahu laa ilaaha illaa huwal hayyul qayyuum, laa ta'khudzuhuu sinatuw wa laa nawm, lahuu maa fis-samaawaati wa maa fil ardh, man dzal-ladzii yasyfa'u 'indahuu illaa bi-idznih, ya'lamu maa bayna aydiihim wa maa khalfahum, wa laa yuhiithuuna bi syay-im min 'ilmihii illaa bimaa syaa', wasi'a kursiyyuhus-samaawaati wal ardh, wa laa ya-uuduhuu hifzhuhumaa wa huwal 'aliyyul 'azhiim.",
            translation = "Allah, tidak ada tuhan selain Dia. Yang Maha Hidup, Yang terus-menerus mengurus makhluk-Nya. Tidak mengantuk dan tidak tidur. Milik-Nya apa yang ada di langit dan apa yang ada di bumi. Siapakah yang dapat memberi syafaat di sisi-Nya tanpa izin-Nya? Dia mengetahui apa yang ada di hadapan mereka dan apa yang di belakang mereka, dan mereka tidak mengetahui sesuatu apa pun tentang ilmu-Nya melainkan apa yang Dia kehendaki. Kursi-Nya meliputi langit dan bumi. Dan Dia tidak merasa berat memelihara keduanya, dan Dia Maha Tinggi, Maha Besar. (QS. Al-Baqarah: 255)",
            targetCount = 1,
            fadhilah = "Siapa yang membacanya di pagi hari akan dilindungi dari gangguan jin hingga petang hari. (HR. An-Nasa'i & Ath-Thabrani)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 102,
            type = DzikirType.PAGI,
            title = "Surat Al-Ikhlas (Dibaca 3x)",
            arabic = "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\nقُلْ هُوَ اللَّهُ أَحَدٌ ۞ اللَّهُ الصَّمَدُ ۞ لَمْ يَلِدْ وَلَمْ يُولَدْ ۞ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ",
            latin = "Qul huwallaahu ahad. Allaahush-shamad. Lam yalid wa lam yuulad. Wa lam yakul-lahuu kufuwan ahad.",
            translation = "Katakanlah: 'Dialah Allah, Yang Maha Esa. Allah adalah Tuhan yang bergantung kepada-Nya segala sesuatu. Dia tiada beranak dan tidak pula diperanakkan, dan tidak ada seorang pun yang setara dengan Dia.'",
            targetCount = 3,
            fadhilah = "Siapa yang membacanya 3 kali di pagi dan petang, akan dicukupkan dari segala keburukan dan marabahaya. (HR. Abu Dawud & At-Tirmidzi)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 103,
            type = DzikirType.PAGI,
            title = "Surat Al-Falaq (Dibaca 3x)",
            arabic = "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\nقُلْ أَعُوذُ بِرَبِّ الْفَلَقِ ۞ مِنْ شَرِّ مَا خَلَقَ ۞ وَمِنْ شَرِّ غَاسِقٍ إِذَا وَقَبَ ۞ وَمِنْ شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ ۞ وَمِنْ شَرِّ حَاسِدٍ إِذَا حَسَدَ",
            latin = "Qul a'uudzu bi rabbil falaq. Min syarri maa khalaq. Wa min syarri ghaasiqin idzaa waqab. Wa min syarrin-naffaatsaati fil 'uqad. Wa min syarri haasidin idzaa hasad.",
            translation = "Katakanlah: 'Aku berlindung kepada Tuhan yang menguasai subuh, dari kejahatan makhluk-Nya, dan dari kejahatan malam apabila telah gelap gulita, dan dari kejahatan wanita-wanita tukang sihir yang menghembus pada buhul-buhul, dan dari kejahatan orang yang dengki apabila ia dengki.'",
            targetCount = 3,
            fadhilah = "Perlindungan terbaik dari kejahatan makhluk, sihir, dan kedengkian. (HR. Abu Dawud & At-Tirmidzi)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 104,
            type = DzikirType.PAGI,
            title = "Surat An-Naas (Dibaca 3x)",
            arabic = "بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيمِ\nقُلْ أَعُوذُ بِرَبِّ النَّاسِ ۞ مَلِكِ النَّاسِ ۞ إِلَهِ النَّاسِ ۞ مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِ ۞ الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ ۞ مِنَ الْجِنَّةِ وَالنَّاسِ",
            latin = "Qul a'uudzu bi rabbin-naas. Malikin-naas. Ilaahin-naas. Min syarril waswaasil khannaas. Alladzii yuwaswisu fii shuduurin-naas. Minal jinnati wan-naas.",
            translation = "Katakanlah: 'Aku berlindung kepada Tuhan manusia, Raja manusia, Sembahan manusia, dari kejahatan bisikan setan yang biasa bersembunyi, yang membisikkan kejahatan ke dalam dada manusia, dari golongan jin dan manusia.'",
            targetCount = 3,
            fadhilah = "Perlindungan dari was-was godaan setan dan jin. (HR. Abu Dawud)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 105,
            type = DzikirType.PAGI,
            title = "Doa Masuk Waktu Pagi",
            arabic = "أَصْبَحْنَا وَأَصْبَحَ الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِي هَذَا الْيَوْمِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا الْيَوْمِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوذُ بِكَ مِنَ الْكَسَلِ وَسُوءِ الْكِبَرِ، رَبِّ أَعُوذُ بِكَ مِنْ عَذَابٍ فِي النَّارِ وَعَذَابٍ فِي الْقَبْرِ",
            latin = "Ashbahnaa wa ashbahal mulku lillaahi wal hamdu lillaah, laa ilaaha illallaahu wahdahu laa syariika lah, lahul mulku wa lahul hamdu wa huwa 'alaa kulli syai-in qadiir. Rabbi as-aluka khayra maa fii haadzal yawmi wa khayra maa ba'dahu, wa a'uudzu bika min syarri maa fii haadzal yawmi wa syarri maa ba'dah. Rabbi a'uudzu bika minal kasali wa suu-il kibar, rabbi a'uudzu bika min 'adzaabin fin-naari wa 'adzaabin fil qabr.",
            translation = "Kami telah memasuki waktu pagi dan kerajaan hanya milik Allah, segala puji bagi Allah. Tidak ada ilah yang berhak disembah selain Allah semata, tiada sekutu bagi-Nya. Milik-Nya lah segala kerajaan dan segala pujian, dan Dia Maha Kuasa atas segala sesuatu. Wahai Tuhanku, aku memohon kepada-Mu kebaikan hari ini dan kebaikan sesudahnya. Dan aku berlindung kepada-Mu dari keburukan hari ini dan keburukan sesudahnya. Wahai Tuhanku, aku berlindung kepada-Mu dari kemalasan dan keburukan di hari tua. Wahai Tuhanku, aku berlindung kepada-Mu dari siksaan api neraka dan siksaan di dalam kubur.",
            targetCount = 1,
            fadhilah = "Doa memohon kebaikan hari dan perlindungan dari siksa kubur serta neraka. (HR. Muslim No. 2723)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 106,
            type = DzikirType.PAGI,
            title = "Sayyidul Istighfar",
            arabic = "اللَّهُمَّ أَنْتَ رَبِّي لَا إِلَهَ إِلَّا أَنْتَ، خَلَقْتَنِي وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عهدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوءُ بِذَنْبِي فَاغْفِرْ لِي فَإِنَّهُ لَا يَغْفِرُ الذُّنُوبَ إِلَّا أَنْتَ",
            latin = "Allaahumma anta rabbii laa ilaaha illaa anta, khalaqtanii wa anaa 'abduka, wa anaa 'alaa 'ahdika wa wa'dika mastatha'tu, a'uudzu bika min syarri maa shana'tu, abuu-u laka bini'matika 'alayya, wa abuu-u bidzanbii faghfir lii fa-innahu laa yaghfirudz-dzunuuba illaa anta.",
            translation = "Ya Allah, Engkau adalah Tuhanku, tiada ilah selain Engkau. Engkau telah menciptakanku dan aku adalah hamba-Mu. Aku senantiasa menepati janji-Mu semampuku. Aku berlindung kepada-Mu dari keburukan yang telah aku perbuat. Aku mengakui nikmat-Mu atasku dan aku mengakui dosaku, maka ampunilah aku karena tiada yang dapat mengampuni dosa melainkan Engkau.",
            targetCount = 1,
            fadhilah = "Barangsiapa mengucapkannya di pagi hari dengan penuh keyakinan lalu meninggal sebelum petang, ia termasuk penghuni surga. (HR. Bukhari No. 6306)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 107,
            type = DzikirType.PAGI,
            title = "Doa Perlindungan dari Marabahaya (Dibaca 3x)",
            arabic = "بِسْمِ اللَّهِ الَّذِي لَا يَضُرُّ مَعَ اسْمِهِ شَيْءٌ فِي الْأَرْضِ وَلَا فِي السَّمَاءِ وَهُوَ السَّمِيعُ الْعَلِيمُ",
            latin = "Bismillaahil-ladzii laa yadhurru ma'as-mihii syai-un fil ardhi wa laa fis-samaa-i wa huwas-samii'ul 'aliim.",
            translation = "Dengan nama Allah yang bersama nama-Nya tiada sesuatu pun di bumi maupun di langit dapat membahayakan, dan Dialah Yang Maha Mendengar lagi Maha Mengetahui.",
            targetCount = 3,
            fadhilah = "Barangsiapa membacanya 3 kali di pagi hari, tidak ada sesuatu pun yang dapat membahayakannya hingga petang. (HR. Abu Dawud No. 5088 & At-Tirmidzi No. 3388)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 108,
            type = DzikirType.PAGI,
            title = "Keridhaan Iman (Dibaca 3x)",
            arabic = "رَضِيتُ بِاللَّهِ رَبًّا، وَبِالْإِسْلَامِ دِينًا، وَبِمُحَمَّدٍ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ نَبِيًّا",
            latin = "Radhiitu billaahi rabbaa, wa bil Islaami diinaa, wa bi Muhammadin shallallaahu 'alayhi wa sallama nabiyyaa.",
            translation = "Aku ridha Allah sebagai Tuhanku, Islam sebagai agamaku, dan Nabi Muhammad shallallahu 'alaihi wa sallam sebagai Nabiku.",
            targetCount = 3,
            fadhilah = "Siapa yang membacanya 3 kali di pagi hari, Allah berhak meridhainya pada hari kiamat. (HR. Abu Dawud No. 5072)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 109,
            type = DzikirType.PAGI,
            title = "Doa Memohon Perbaikan Segala Urusan",
            arabic = "يَا حَيُّ يَا قَيُّومُ بِرَحْمَتِكَ أَسْتَغِيثُ، أَصْلِحْ لِي شَأْنِي كُلَّهُ، وَلَا تَكِلْنِي إِلَى نَفْسِي طَرْفَةَ عَيْنٍ",
            latin = "Yaa Hayyu yaa Qayyuum, bi rahmatika astaghiits, ashlih lii sya'nii kullah, wa laa takilnii ilaa nafsii tharfata 'ayn.",
            translation = "Wahai Dzat Yang Maha Hidup, wahai Dzat Yang Maha Berdiri Sendiri, dengan rahmat-Mu aku memohon pertolongan. Perbaikilah seluruh urusanku dan janganlah Engkau serahkan aku kepada diriku sendiri walau sekejap mata pun.",
            targetCount = 1,
            fadhilah = "Memohon pertolongan dan pemeliharaan Allah dalam setiap tarikan nafas. (HR. An-Nasa'i & Al-Hakim)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 110,
            type = DzikirType.PAGI,
            title = "Doa Memohon Ilmu, Rezeki & Amal",
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمًا نَافِعًا، وَرِزْقًا طَيِّبًا، وَعَمَلًا مُتَقَبَّلًا",
            latin = "Allaahumma innii as-aluka 'ilman naafi'aa, wa rizqan thayyibaa, wa 'amalan mutaqabbalaa.",
            translation = "Ya Allah, sesungguhnya aku memohon kepada-Mu ilmu yang bermanfaat, rezeki yang halal dan baik, serta amalan yang diterima di sisi-Mu.",
            targetCount = 1,
            fadhilah = "Dibaca setiap pagi setelah shalat Subuh untuk keberkahan aktivitas. (HR. Ibnu Majah No. 925)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),
        DzikirItem(
            id = 111,
            type = DzikirType.PAGI,
            title = "Tasbih Pembuka Pagi (Dibaca 100x)",
            arabic = "سُبْحَانَ اللَّهِ وَبِحَمْدِهِ",
            latin = "Subhaanallaahi wa bihamdih.",
            translation = "Maha Suci Allah dan dengan segala puji bagi-Nya.",
            targetCount = 100,
            fadhilah = "Barangsiapa membacanya 100 kali sehari, dosa-dosanya akan dihapuskan walau sebanyak buih di lautan. (HR. Bukhari No. 6405 & Muslim No. 2691)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Pagi)"
        ),

        // ==========================================
        // DZIKIR PETANG (alrabiauinjkt.id/blog/detail/1113/dzikir-petang)
        // ==========================================
        DzikirItem(
            id = 201,
            type = DzikirType.PETANG,
            title = "Membaca Ayat Kursi (Petang)",
            arabic = "اللَّهُ لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ وَلَا يَئُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ",
            latin = "Allahu laa ilaaha illaa huwal hayyul qayyuum, laa ta'khudzuhuu sinatuw wa laa nawm, lahuu maa fis-samaawaati wa maa fil ardh, man dzal-ladzii yasyfa'u 'indahuu illaa bi-idznih, ya'lamu maa bayna aydiihim wa maa khalfahum, wa laa yuhiithuuna bi syay-im min 'ilmihii illaa bimaa syaa', wasi'a kursiyyuhus-samaawaati wal ardh, wa laa ya-uuduhuu hifzhuhumaa wa huwal 'aliyyul 'azhiim.",
            translation = "Allah, tidak ada tuhan selain Dia. Yang Maha Hidup, Yang terus-menerus mengurus makhluk-Nya... (QS. Al-Baqarah: 255)",
            targetCount = 1,
            fadhilah = "Siapa yang membacanya di petang hari akan dilindungi dari gangguan jin hingga keesokan paginya. (HR. An-Nasa'i)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Petang)"
        ),
        DzikirItem(
            id = 202,
            type = DzikirType.PETANG,
            title = "Al-Mu'awwidzat (Al-Ikhlas, Al-Falaq, An-Naas) (Masing-masing 3x)",
            arabic = "قُلْ هُوَ اللَّهُ أَحَدٌ... ۞ قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ... ۞ قُلْ أَعُوذُ بِرَبِّ النَّاسِ...",
            latin = "Membaca Surat Al-Ikhlas (3x), Surat Al-Falaq (3x), dan Surat An-Naas (3x).",
            translation = "Katakanlah: Dialah Allah Yang Maha Esa... Katakanlah: Aku berlindung kepada Tuhan Yang menguasai subuh... Katakanlah: Aku berlindung kepada Tuhan manusia...",
            targetCount = 3,
            fadhilah = "Akan mencukupkan dan melindungimu dari segala marabahaya di malam hari. (HR. Abu Dawud & At-Tirmidzi)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Petang)"
        ),
        DzikirItem(
            id = 203,
            type = DzikirType.PETANG,
            title = "Doa Masuk Waktu Petang",
            arabic = "أَمْسَيْنَا وَأَمْسَى الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِي هَذِهِ اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهَا، وَأَعُوذُ بِكَ مِنْ شَرِّ مَا فِي هَذِهِ اللَّيْلَةِ وَشَرِّ مَا بَعْدَهَا، رَبِّ أَعُوذُ بِكَ مِنَ الْكَسَلِ وَسُوءِ الْكِبَرِ، رَبِّ أَعُوذُ بِكَ مِنْ عَذَابٍ فِي النَّارِ وَعَذَابٍ فِي الْقَبْرِ",
            latin = "Amsaynaa wa amsal mulku lillaahi wal hamdu lillaah, laa ilaaha illallaahu wahdahu laa syariika lah, lahul mulku wa lahul hamdu wa huwa 'alaa kulli syai-in qadiir. Rabbi as-aluka khayra maa fii haadzihil laylati wa khayra maa ba'dahaa, wa a'uudzu bika min syarri maa fii haadzihil laylati wa syarri maa ba'dahaa. Rabbi a'uudzu bika minal kasali wa suu-il kibar, rabbi a'uudzu bika min 'adzaabin fin-naari wa 'adzaabin fil qabr.",
            translation = "Kami telah memasuki waktu petang dan kerajaan hanya milik Allah, segala puji bagi Allah. Tiada ilah selain Allah semata, tiada sekutu bagi-Nya. Milik-Nya kerajaan dan pujian, dan Dia Maha Kuasa atas segala sesuatu. Wahai Tuhanku, aku memohon kebaikan malam ini dan kebaikan sesudahnya, dan aku berlindung dari keburukan malam ini dan keburukan sesudahnya. Wahai Tuhanku, aku berlindung dari kemalasan, keburukan usia tua, serta siksa api neraka dan kubur.",
            targetCount = 1,
            fadhilah = "Doa perlindungan sepanjang malam dari segala marabahaya. (HR. Muslim No. 2723)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Petang)"
        ),
        DzikirItem(
            id = 204,
            type = DzikirType.PETANG,
            title = "Doa Perlindungan dari Kalimat Sempurna (Dibaca 3x)",
            arabic = "أَعُوذُ بِكَلِمَاتِ اللَّهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ",
            latin = "A'uudzu bikalimaatillaahit-taammaati min syarri maa khalaq.",
            translation = "Aku berlindung dengan kalimat-kalimat Allah yang sempurna dari kejahatan makhluk yang Dia ciptakan.",
            targetCount = 3,
            fadhilah = "Barangsiapa membacanya 3 kali di petang hari, niscaya tidak akan terkena racun/sengatan binatang berbisa pada malam itu. (HR. Muslim No. 2709)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Petang)"
        ),
        DzikirItem(
            id = 205,
            type = DzikirType.PETANG,
            title = "Doa Perlindungan Marabahaya Petang (Dibaca 3x)",
            arabic = "بِسْمِ اللَّهِ الَّذِي لَا يَضُرُّ مَعَ اسْمِهِ شَيْءٌ فِي الْأَرْضِ وَلَا فِي السَّمَاءِ وَهُوَ السَّمِيعُ الْعَلِيمُ",
            latin = "Bismillaahil-ladzii laa yadhurru ma'as-mihii syai-un fil ardhi wa laa fis-samaa-i wa huwas-samii'ul 'aliim.",
            translation = "Dengan nama Allah yang bersama nama-Nya tiada sesuatu pun di bumi maupun di langit dapat membahayakan, dan Dialah Yang Maha Mendengar lagi Maha Mengetahui.",
            targetCount = 3,
            fadhilah = "Perlindungan mutlak hingga keesokan pagi. (HR. At-Tirmidzi & Abu Dawud)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Petang)"
        ),
        DzikirItem(
            id = 206,
            type = DzikirType.PETANG,
            title = "Sayyidul Istighfar Petang",
            arabic = "اللَّهُمَّ أَنْتَ رَبِّي لَا إِلَهَ إِلَّا أَنْتَ، خَلَقْتَنِي وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوءُ بِذَنْبِي فَاغْفِرْ لِي فَإِنَّهُ لَا يَغْفِرُ الذُّنُوبَ إِلَّا أَنْتَ",
            latin = "Allaahumma anta rabbii laa ilaaha illaa anta, khalaqtanii wa anaa 'abduka, wa anaa 'alaa 'ahdika wa wa'dika mastatha'tu, a'uudzu bika min syarri maa shana'tu, abuu-u laka bini'matika 'alayya, wa abuu-u bidzanbii faghfir lii fa-innahu laa yaghfirudz-dzunuuba illaa anta.",
            translation = "Ya Allah, Engkau adalah Tuhanku, tiada ilah selain Engkau. Engkau telah menciptakanku dan aku adalah hamba-Mu...",
            targetCount = 1,
            fadhilah = "Barangsiapa membacanya di petang hari dan meninggal malam itu, ia termasuk penghuni surga. (HR. Bukhari No. 6306)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Petang)"
        ),
        DzikirItem(
            id = 207,
            type = DzikirType.PETANG,
            title = "Dzikir Tauhid Petang (Dibaca 10x atau 100x)",
            arabic = "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ",
            latin = "Laa ilaaha illallaahu wahdahu laa syariika lah, lahul mulku wa lahul hamdu, wa huwa 'alaa kulli syai-in qadiir.",
            translation = "Tiada ilah yang berhak disembah selain Allah semata, tiada sekutu bagi-Nya. Milik-Nya segala kerajaan dan segala pujian, dan Dia Maha Kuasa atas segala sesuatu.",
            targetCount = 10,
            fadhilah = "Mendapat pahala memerdekakan empat orang budak dari keturunan Nabi Ismail. (HR. Muslim No. 2693)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Petang)"
        ),

        // ==========================================
        // DZIKIR SEBELUM TIDUR (alrabiauinjkt.id/blog/detail/1119/dzikir-sebelum-tidur)
        // ==========================================
        DzikirItem(
            id = 301,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Meniup Tangan & Membaca Al-Mu'awwidzat (3x)",
            arabic = "قُلْ هُوَ اللَّهُ أَحَدٌ... ۞ قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ... ۞ قُلْ أَعُوذُ بِرَبِّ النَّاسِ...",
            latin = "Merapatkan kedua telapak tangan lalu meniupnya perlahan dan membaca Al-Ikhlas, Al-Falaq, An-Naas, lalu mengusapkan kedua telapak tangan ke bagian tubuh yang terjangkau (kepala, wajah, dan tubuh bagian depan). Diulangi 3 kali.",
            translation = "Nabi shallallahu 'alaihi wa sallam apabila hendak tidur setiap malam, beliau merapatkan kedua telapak tangannya lalu meniupnya dan membaca Al-Ikhlas, Al-Falaq, dan An-Naas, kemudian mengusapkan ke seluruh tubuh yang terjangkau.",
            targetCount = 3,
            fadhilah = "Sunnah Rasulullah shallallahu 'alaihi wa sallam setiap malam sebagai benteng penjaga tidur. (HR. Bukhari No. 5017)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        ),
        DzikirItem(
            id = 302,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Membaca Ayat Kursi Sebelum Berbaring",
            arabic = "اللَّهُ لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ وَلَا يَئُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ",
            latin = "Allahu laa ilaaha illaa huwal hayyul qayyuum, laa ta'khudzuhuu sinatuw wa laa nawm...",
            translation = "Allah, tidak ada tuhan selain Dia, Yang Maha Hidup, Yang terus-menerus mengurus makhluk-Nya...",
            targetCount = 1,
            fadhilah = "Allah akan senantiasa mengutus malaikat penjaga kepadamu dan setan tidak akan mampu mendekatimu hingga pagi hari. (HR. Bukhari No. 2311)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        ),
        DzikirItem(
            id = 303,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Dua Ayat Terakhir Surat Al-Baqarah (285–286)",
            arabic = "آمَنَ الرَّسُولُ بِمَا أُنْزِلَ إِلَيْهِ مِنْ رَبِّهِ وَالْمُؤْمِنُونَ كُلٌّ آمَنَ بِاللَّهِ وَمَلَائِكَتِهِ وَكُتُبِهِ وَرُسُلِهِ لَا نُفَرِّقُ بَيْنَ أَحَدٍ مِنْ رُسُلِهِ وَقَالُوا سَمِعْنَا وَأَطَعْنَا غُفْرَانَكَ رَبَّنَا وَإِلَيْكَ الْمَصِيرُ ۞ لَا يُكَلِّفُ اللَّهُ نَفْسًا إِلَّا وُسْعَهَا لَهَا مَا كَسَبَتْ وَعَلَيْهَا مَا اكْتَسَبَتْ رَبَّنَا لَا تُؤَاخِذْنَا إِنْ نَسِينَا أَوْ أَخْطَأْنَا رَبَّنَا وَلَا تَحْمِلْ عَلَيْنَا إِصْرًا كَمَا حَمَلْتَهُ عَلَى الَّذِينَ مِنْ قَبْلِنَا رَبَّنَا وَلَا تُحَمِّلْنَا مَا لَا طَاقَةَ لَنَا بِهِ وَاعْفُ عَنَّا وَاغْفِرْ لَنَا وَارْحَمْنَا أَنْتَ مَوْلَانَا فَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِينَ",
            latin = "Aamanar-rasuulu bimaa unzila ilayhi mir-rabbihii wal mu'minuun, kullun aamana billaahi wa malaa-ikatihii wa kutubihii wa rusulih, laa nufarriqu bayna ahadim mir-rusulih, wa qaaluu sami'naa wa atha'naa ghufraanaka rabbanaa wa ilaykal mashiir. Laa yukallifullaahu nafsan illaa wus'ahaa, lahaa maa kasabat wa 'alayhaa maktasabat, rabbanaa laa tu-aakhidznaa in nasiinaa aw akhtha'naa, rabbanaa wa laa tahmil 'alaynaa ishran kamaa hamaltahuu 'alal-ladziina min qablinaa, rabbanaa wa laa tuhammilnaa maa laa thaaqata lanaa bih, wa'fu 'annaa waghfir lanaa warhamnaa anta mawlaanaa fanshurnaa 'alal qawmil kaafiriin.",
            translation = "Rasul (Muhammad) beriman kepada apa yang diturunkan kepadanya dari Tuhannya, demikian pula orang-orang yang beriman... (QS. Al-Baqarah: 285-286)",
            targetCount = 1,
            fadhilah = "Siapa yang membaca dua ayat terakhir surat Al-Baqarah di malam hari, maka kedua ayat itu telah mencukupkannya dari segala keburukan. (HR. Bukhari No. 5009 & Muslim No. 808)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        ),
        DzikirItem(
            id = 304,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Doa Merebahkan Diri di Lambung Kanan",
            arabic = "بِاسْمِكَ رَبِّي وَضَعْتُ جَنْبِي، وَبِكَ أَرْفَعُهُ، فَإِنْ أَمْسَكْتَ نَفْسِي فَارْحَمْهَا، وَإِنْ أَرْسَلْتَهَا فَاحْفَظْهَا بِمَا تَحْفَظُ بِهِ عِبَادَكَ الصَّالِحِينَ",
            latin = "Bismika rabbii wadha'tu janbii, wa bika arfa'uh, fa-in amsakta nafsii farhamhaa, wa in arsaltahaa fahfazh-haa bimaa tahfazhu bihii 'ibaadakash-shaalihiin.",
            translation = "Dengan nama-Mu wahai Tuhanku, aku meletakkan lambungku (tidur), dan dengan nama-Mu pula aku mengangkatnya (bangun). Jika Engkau menahan jiwaku (mematikanku), maka rahmatilah ia. Dan jika Engkau melepaskannya (menghidupkanku kembali), maka jagalah ia sebagaimana Engkau menjaga hamba-hamba-Mu yang shalih.",
            targetCount = 1,
            fadhilah = "Adab berbaring miring ke kanan dengan pasrah penuh kepada penjagaan Allah. (HR. Bukhari No. 6320 & Muslim No. 2714)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        ),
        DzikirItem(
            id = 305,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Doa Penyerahan Diri (Dibaca Sebelum Terlelap)",
            arabic = "اللَّهُمَّ أَسْلَمْتُ نَفْسِي إِلَيْكَ، وَفَوَّضْتُ أَمْرِي إِلَيْكَ، وَوَجَّهْتُ وَجْهِي إِلَيْكَ، وَأَلْجَأْتُ ظَهْرِي إِلَيْكَ، رَغْبَةً وَرَهْبَةً إِلَيْكَ، لَا مَلْجَأَ وَلَا مَنْجَا مِنْكَ إِلَّا إِلَيْكَ، آمَنْتُ بِكِتَابِكَ الَّذِي أَنْزَلْتَ، وَبِنَبِيِّكَ الَّذِي أَرْسَلْتَ",
            latin = "Allaahumma aslamtu nafsii ilayk, wa fawwadhtu amrii ilayk, wa wajjahtu wajhiya ilayk, wa alja'tu zhahrii ilayk, raghbatan wa rahbatan ilayk, laa malja-a wa laa manjaa minka illaa ilayk, aamantu bikitaabikal-ladzii anzalta, wa bi nabiyyikal-ladzii arsalt.",
            translation = "Ya Allah, aku serahkan diriku kepada-Mu, aku serahkan urusanku kepada-Mu, aku hadapkan wajahku kepada-Mu, dan aku sandarkan punggungku kepada-Mu, dengan penuh harap dan cemas kepada-Mu. Tiada tempat berlindung dan tempat selamat dari ancaman-Mu melainkan hanya kepada-Mu. Aku beriman kepada Kitab yang telah Engkau turunkan dan kepada Nabi yang telah Engkau utus.",
            targetCount = 1,
            fadhilah = "Jika engkau meninggal dunia pada malam itu, maka engkau mati di atas fitrah kesucian Islam. (HR. Bukhari No. 247 & Muslim No. 2710)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        ),
        DzikirItem(
            id = 306,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Tasbih Fatimah (33x Tasbih, 33x Tahmid, 34x Takbir)",
            arabic = "سُبْحَانَ اللَّهِ (٣٣×) الْحَمْدُ لِلَّهِ (٣٣×) اللَّهُ أَكْبَرُ (٣٤×)",
            latin = "Subhaanallaah (33x), Alhamdulillaah (33x), Allaahu Akbar (34x).",
            translation = "Maha Suci Allah (33 kali), Segala puji bagi Allah (33 kali), Allah Maha Besar (34 kali).",
            targetCount = 33,
            fadhilah = "Wasiat Nabi kepada Ali dan Fatimah; lebih berharga dan memberi kekuatan melebihi seorang pembantu rumah tangga. (HR. Bukhari No. 3705 & Muslim No. 2727)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        ),
        DzikirItem(
            id = 307,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Doa Perlindungan dari Hari Kebangkitan (Dibaca 3x)",
            arabic = "اللَّهُمَّ قِنِي عَذَابَكَ يَوْمَ تَبْعَثُ عِبَادَكَ",
            latin = "Allaahumma qinii 'adzaabaka yawma tab'atsu 'ibaadak.",
            translation = "Ya Allah, lindungilah aku dari azab-Mu pada hari ketika Engkau membangkitkan hamba-hamba-Mu.",
            targetCount = 3,
            fadhilah = "Nabi meletakkan tangan kanan di bawah pipi kanan ketika membaca doa ini sebelum tidur. (HR. Abu Dawud No. 5045)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        ),
        DzikirItem(
            id = 308,
            type = DzikirType.SEBELUM_TIDUR,
            title = "Doa Penutup Sebelum Tidur",
            arabic = "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَا",
            latin = "Bismikallaahumma amuutu wa ahyaa.",
            translation = "Dengan nama-Mu ya Allah, aku mati dan aku hidup.",
            targetCount = 1,
            fadhilah = "Doa penutup saat mata terpejam untuk tidur. (HR. Bukhari No. 6312)",
            source = "Al-Qur'an & As-Sunnah (Dzikir Sebelum Tidur)"
        )
    )
}

typealias DzikirAlRabiahData = DzikirData
typealias DzikirRumayshoData = DzikirData
