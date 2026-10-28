package com.example.data.local

import com.example.data.local.entity.DoaEntity

/**
 * Kumpulan Doa Harian Shahih yang bersumber dari:
 * 1. Kitab Hishnul Muslim (Perisai Muslim / حصن المسلم) karya Syaikh Sa'id bin Ali bin Wahf Al-Qahthani
 * 2. Kumpulan Doa Sehari-hari berbasis Al-Qur'an dan As-Sunnah Ash-Shahihah.
 */
object DefaultDoaData {
    val initialDoas = listOf(
        // === 1. BANGUN & TIDUR ===
        DoaEntity(
            title = "Doa Bangun Tidur",
            arabic = "الْحَمْدُ لِلَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُورُ",
            latin = "Alhamdu lillaahil-ladzii ahyaanaa ba'da maa amaatanaa wa ilaihin-nusyuur.",
            translation = "Segala puji bagi Allah yang telah menghidupkan kami setelah mematikan kami, dan kepada-Nya lah tempat kembali.",
            category = "Bangun & Tidur",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 6312 & Muslim No. 2711"
        ),
        DoaEntity(
            title = "Doa Sebelum Tidur",
            arabic = "بِاسْمِكَ اللَّهُمَّ أَحْيَا وَأَمُوتُ",
            latin = "Bismikallaahumma ahyaa wa amuut.",
            translation = "Dengan nama-Mu ya Allah, aku hidup dan aku mati.",
            category = "Bangun & Tidur",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 6324 & Muslim No. 2711"
        ),
        DoaEntity(
            title = "Doa Ketika Terbangun Tengah Malam",
            arabic = "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، سُبْحَانَ اللَّهِ، وَالْحَمْدُ لِلَّهِ، وَلَا إِلَهَ إِلَّا اللَّهُ، وَاللَّهُ أَكْبَرُ، وَلَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ الْعَلِيِّ الْعَظِيمِ، رَبِّ اغْفِرْ لِي",
            latin = "Laa ilaaha illallaahu wahdahu laa syariika lah, lahul mulku wa lahul hamdu, wa huwa 'alaa kulli syai-in qadiir. Subhaanallaah, wal hamdu lillaah, wa laa ilaaha illallaah, wallaahu akbar, wa laa hawla wa laa quwwata illaa billaahil 'aliyyil 'azhiim. Rabbighfir lii.",
            translation = "Tiada ilah yang berhak disembah selain Allah semata, tiada sekutu bagi-Nya. Milik-Nya lah segala kerajaan dan milik-Nya lah segala pujian, dan Dia Maha Kuasa atas segala sesuatu. Maha Suci Allah, segala puji bagi Allah, tiada ilah selain Allah, Allah Maha Besar, dan tiada daya serta upaya kecuali dengan pertolongan Allah Yang Maha Tinggi lagi Maha Agung. Ya Tuhanku, ampunilah aku.",
            category = "Bangun & Tidur",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 1154"
        ),
        DoaEntity(
            title = "Doa Ketika Merasa Takut & Gelisah dalam Tidur",
            arabic = "أَعُوذُ بِكَلِمَاتِ اللَّهِ التَّامَّاتِ مِنْ غَضَبِهِ وَعِقَابِهِ، وَشَرِّ عِبَادِهِ، وَمِنْ هَمَزَاتِ الشَّيَاطِينِ وَأَنْ يَحْضُرُونِ",
            latin = "A'uudzu bikalimaatillaahit-taammaati min ghadhabihii wa 'iqaa-bihi, wa syarri 'ibaadih, wa min hamazaatisy-syayaathiini wa an yahdhuruun.",
            translation = "Aku berlindung dengan kalimat-kalimat Allah yang sempurna dari murka-Nya, siksa-Nya, dari kejahatan hamba-hamba-Nya, serta dari bisikan-bisikan setan dan agar mereka tidak mendekatiku.",
            category = "Bangun & Tidur",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 3893 & At-Tirmidzi No. 3528"
        ),

        // === 2. PAKAIAN & TOILET ===
        DoaEntity(
            title = "Doa Memakai Pakaian",
            arabic = "الْحَمْدُ لِلَّهِ الَّذِي كَسَانِي هَذَا الثَّوْبَ وَرَزَقَنِيهِ مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّةٍ",
            latin = "Alhamdu lillaahil-ladzii kasaanii haadzats-tsawba wa razaqaniihi min ghayri hawlin minnii wa laa quwwah.",
            translation = "Segala puji bagi Allah yang telah memakaikan pakaian ini kepadaku dan merezekikannya kepadaku tanpa daya dan kekuatan dariku.",
            category = "Pakaian & Toilet",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 4023 & At-Tirmidzi No. 3458"
        ),
        DoaEntity(
            title = "Doa Memakai Pakaian Baru",
            arabic = "اللَّهُمَّ لَكَ الْحَمْدُ أَنْتَ كَسَوْتَنِيهِ، أَسْأَلُكَ مِنْ خَيْرِهِ وَخَيْرِ مَا صُنِعَ لَهُ، وَأَعُوذُ بِكَ مِنْ شَرِّهِ وَشَرِّ مَا صُنِعَ لَهُ",
            latin = "Allaahumma lakal hamdu anta kasawtaniihi, as-aluka min khayrihii wa khayri maa shuni'a lah, wa a'uudzu bika min syarrihii wa syarri maa shuni'a lah.",
            translation = "Ya Allah, hanya bagi-Mu segala puji, Engkaulah yang telah memakaikannya kepadaku. Aku memohon kepada-Mu kebaikannya dan kebaikan tujuan ia dibuat, dan aku berlindung kepada-Mu dari keburukannya dan keburukan tujuan ia dibuat.",
            category = "Pakaian & Toilet",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 4020 & At-Tirmidzi No. 1767"
        ),
        DoaEntity(
            title = "Doa Menanggalkan Pakaian",
            arabic = "بِسْمِ اللَّهِ",
            latin = "Bismillaah.",
            translation = "Dengan nama Allah (penghalang antara pandangan jin dan aurat manusia).",
            category = "Pakaian & Toilet",
            source = "Kitab Hishnul Muslim",
            reference = "HR. At-Tirmidzi No. 606 & Ibnu Majah No. 297"
        ),
        DoaEntity(
            title = "Doa Masuk Kamar Mandi (WC)",
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْخُبُثِ وَالْخَبَائِثِ",
            latin = "Allaahumma innii a'uudzu bika minal khubutsi wal khabaa-its.",
            translation = "Ya Allah, sesungguhnya aku berlindung kepada-Mu dari godaan setan laki-laki dan setan perempuan.",
            category = "Pakaian & Toilet",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 142 & Muslim No. 375"
        ),
        DoaEntity(
            title = "Doa Keluar Kamar Mandi (WC)",
            arabic = "غُفْرَانَكَ",
            latin = "Ghufraanak.",
            translation = "Aku memohon ampunan-Mu, ya Allah.",
            category = "Pakaian & Toilet",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 30 & At-Tirmidzi No. 7"
        ),

        // === 3. WUDHU & SHALAT ===
        DoaEntity(
            title = "Doa Sebelum Berwudhu",
            arabic = "بِسْمِ اللَّهِ",
            latin = "Bismillaah.",
            translation = "Dengan nama Allah.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 101 & Ibnu Majah No. 399"
        ),
        DoaEntity(
            title = "Doa Selesai Berwudhu",
            arabic = "أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، وَأَشْهَدُ أَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُولُهُ، اللَّهُمَّ اجْعَلْنِي مِنَ التَّوَّابِينَ وَاجْعَلْنِي مِنَ الْمُتَطَهِّرِينَ",
            latin = "Asyhadu allaa ilaaha illallaahu wahdahu laa syariika lah, wa asyhadu anna Muhammadan 'abduhuu wa rasuuluh. Allaahummaj'alnii minat-tawwaabiina waj'alnii minal mutathahhiriin.",
            translation = "Aku bersaksi bahwa tiada ilah yang berhak disembah selain Allah semata, tiada sekutu bagi-Nya, dan aku bersaksi bahwa Muhammad adalah hamba dan utusan-Nya. Ya Allah, jadikanlah aku termasuk orang-orang yang bertaubat dan jadikanlah aku termasuk orang-orang yang menyucikan diri.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Muslim No. 234 & At-Tirmidzi No. 55"
        ),
        DoaEntity(
            title = "Doa Setelah Mendengar Adzan",
            arabic = "اللَّهُمَّ رَبَّ هَذِهِ الدَّعْوَةِ التَّامَّةِ، وَالصَّلَاةِ الْقَائِمَةِ، آتِ مُحَمَّدًا الْوَسِيلَةَ وَالْفَضِيلَةَ، وَابْعَثْهُ مَقَامًا مَحْمُودًا الَّذِي وَعَدْتَهُ",
            latin = "Allaahumma rabba haadzihid-da'watit-taammah, wash-shalaatil qaa-imah, aati Muhammadanil wasiilata wal fadhiilah, wab'atshu maqaamam mahmuudanil-ladzii wa'adtah.",
            translation = "Ya Allah, Tuhan pemilik panggilan yang sempurna ini dan shalat yang senantiasa didirikan, berikanlah kepada Nabi Muhammad wasilah dan keutamaan, serta tempatkanlah beliau pada kedudukan mulia yang telah Engkau janjikan.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 614"
        ),
        DoaEntity(
            title = "Doa Istiftah dalam Shalat",
            arabic = "اللَّهُمَّ بَاعِدْ بَيْنِي وَبَيْنَ خَطَايَايَ كَمَا بَاعَدْتَ بَيْنَ الْمَشْرِقِ وَالْمَغْرِبِ، اللَّهُمَّ نَقِّنِي مِنْ خَطَايَايَ كَمَا يُنَقَّى الثَّوْبُ الْأَبْيَضُ مِنَ الدَّنَسِ، اللَّهُمَّ اغْسِلْنِي مِنْ خَطَايَايَ بِالثَّلْجِ وَالْمَاءِ وَالْبَرَدِ",
            latin = "Allaahumma baa'id baynii wa bayna khathaayaaya kamaa baa'adta baynal masyriqi wal maghrib. Allaahumma naqqinii min khathaayaaya kamaa yunaqqats-tsawbul abyadhu minad-danas. Allaahummaghsilnii min khathaayaaya bits-tsalji wal maa-i wal barad.",
            translation = "Ya Allah, jauhkanlah antara aku dan kesalahan-kesalahanku sebagaimana Engkau menjauhkan antara timur dan barat. Ya Allah, bersihkanlah aku dari kesalahan-kesalahanku sebagaimana kain putih dibersihkan dari kotoran. Ya Allah, cucilah aku dari kesalahan-kesalahanku dengan salju, air, dan embun es.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 744 & Muslim No. 598"
        ),
        DoaEntity(
            title = "Doa Ruku' dalam Shalat",
            arabic = "سُبْحَانَ رَبِّيَ الْعَظِيمِ وَبِحَمْدِهِ",
            latin = "Subhaana rabbiyal 'azhiimi wa bihamdih. (3x)",
            translation = "Maha Suci Tuhanku Yang Maha Agung dan dengan memuji-Nya.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 870 & At-Tirmidzi No. 261"
        ),
        DoaEntity(
            title = "Doa I'tidal (Bangkit dari Ruku')",
            arabic = "رَبَّنَا وَلَكَ الْحَمْدُ، حَمْدًا كَثِيرًا طَيِّبًا مُبَارَكًا فِيهِ",
            latin = "Rabbanaa wa lakal hamdu, hamdan katsiiran thayyiban mubaarakan fiih.",
            translation = "Wahai Tuhan kami, bagi-Mu lah segala pujian, pujian yang banyak, baik, lagi penuh keberkahan di dalamnya.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 799"
        ),
        DoaEntity(
            title = "Doa Sujud dalam Shalat",
            arabic = "سُبْحَانَ رَبِّيَ الْأَعْلَى وَبِحَمْدِهِ",
            latin = "Subhaana rabbiyal a'laa wa bihamdih. (3x)",
            translation = "Maha Suci Tuhanku Yang Maha Tinggi dan dengan memuji-Nya.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 870 & Ibnu Majah No. 888"
        ),
        DoaEntity(
            title = "Doa Duduk Antara Dua Sujud",
            arabic = "رَبِّ اغْفِرْ لِي، وَارْحَمْنِي، وَاجْبُرْنِي، وَارْفَعْنِي، وَارْزُقْنِي، وَاهْدِنِي، وَعَافِنِي",
            latin = "Rabbighfir lii, warhamnii, wajburnii, warfa'nii, warzuqnii, wahdinii, wa 'aafinii.",
            translation = "Ya Tuhanku, ampunilah aku, rahmatilah aku, cukupkanlah kekuranganku, tinggikanlah derajatku, berilah rezeki kepadaku, tunjukilah aku ke jalan yang lurus, dan berikanlah kesehatan/keselamatan kepadaku.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 850 & At-Tirmidzi No. 284"
        ),
        DoaEntity(
            title = "Doa Sebelum Salam (Perlindungan 4 Perkara)",
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ عَذَابِ جَهَنَّمَ، وَمِنْ عَذَابِ الْقَبْرِ، وَمِنْ فِتْنَةِ الْمَحْيَا وَالْمَمَاتِ، وَمِنْ شَرِّ فِتْنَةِ الْمَسِيحِ الدَّجَّالِ",
            latin = "Allaahumma innii a'uudzu bika min 'adzaabi jahannama, wa min 'adzaabil qabri, wa min fitnatil mahyaa wal mamaati, wa min syarri fitnatil masiihid-dajjaal.",
            translation = "Ya Allah, sesungguhnya aku berlindung kepada-Mu dari azab Jahannam, dari azab kubur, dari fitnah kehidupan dan kematian, serta dari keburukan fitnah Dajjal.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 1377 & Muslim No. 588"
        ),
        DoaEntity(
            title = "Dzikir Setelah Shalat Fardhu",
            arabic = "أَسْتَغْفِرُ اللَّهَ (٣×) اللَّهُمَّ أَنْتَ السَّلَامُ وَمِنْكَ السَّلَامُ، تَبَارَكْتَ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ",
            latin = "Astaghfirullaah (3x). Allaahumma antas-salaamu wa minkas-salaamu, tabaarakta yaa dzal jalaali wal ikraam.",
            translation = "Aku memohon ampun kepada Allah (3 kali). Ya Allah, Engkaulah As-Salam (Yang Memberi Keselamatan) dan dari-Mu lah keselamatan, Maha Berkah Engkau, wahai Tuhan Yang Memiliki Keagungan dan Kemuliaan.",
            category = "Wudhu & Shalat",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Muslim No. 591"
        ),

        // === 4. RUMAH & MASJID ===
        DoaEntity(
            title = "Doa Keluar Rumah",
            arabic = "بِسْمِ اللَّهِ تَوَكَّلْتُ عَلَى اللَّهِ، لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ",
            latin = "Bismillaahi tawakkaltu 'alallaah, laa hawla wa laa quwwata illaa billaah.",
            translation = "Dengan nama Allah, aku bertawakal kepada Allah. Tiada daya dan tiada kekuatan melainkan dengan pertolongan Allah semata.",
            category = "Rumah & Masjid",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 5095 & At-Tirmidzi No. 3426"
        ),
        DoaEntity(
            title = "Doa Masuk Rumah",
            arabic = "بِسْمِ اللَّهِ وَلَجْنَا، وَبِسْمِ اللَّهِ خَرَجْنَا، وَعَلَى رَبِّنَا تَوَكَّلْنَا",
            latin = "Bismillaahi walajnaa, wa bismillaahi kharajnaa, wa 'alaa rabbinaa tawakkalnaa.",
            translation = "Dengan nama Allah kami masuk, dan dengan nama Allah kami keluar, dan kepada Tuhan kami, kami berserah diri.",
            category = "Rumah & Masjid",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 5096"
        ),
        DoaEntity(
            title = "Doa Menuju ke Masjid",
            arabic = "اللَّهُمَّ اجْعَلْ فِي قَلْبِي نُورًا، وَفِي لِسَانِي نُورًا، وَفِي سَمْعِي نُورًا، وَفِي بَصَرِي نُورًا، وَمِنْ فَوْقِي نُورًا، وَمِنْ تَحْتِي نُورًا، وَعَنْ يَمِينِي نُورًا، وَعَنْ شِمَالِي نُورًا، وَمِنْ أَمَامِي نُورًا، وَمِنْ خَلْفِي نُورًا، وَاجْعَلْ فِي نَفْسِي نُورًا، وَأَعْظِمْ لِي نُورًا",
            latin = "Allaahummaj'al fii qalbii nuuraa, wa fii lisaanii nuuraa, wa fii sam'ii nuuraa, wa fii basharii nuuraa, wa min fawqii nuuraa, wa min tahtii nuuraa, wa 'an yamiinii nuuraa, wa 'an syimaalii nuuraa, wa min amaamii nuuraa, wa min khalfii nuuraa, waj'al fii nafsii nuuraa, wa a'zhim lii nuuraa.",
            translation = "Ya Allah, jadikanlah cahaya di hatiku, cahaya di lisanku, cahaya di pendengaranku, cahaya di penglihatanku, cahaya di atasku, cahaya di bawahku, cahaya di sebelah kananku, cahaya di sebelah kiriku, cahaya di depanku, cahaya di belakangku, jadikanlah cahaya dalam jiwaku, dan perbesarlah cahaya untukku.",
            category = "Rumah & Masjid",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 6316 & Muslim No. 763"
        ),
        DoaEntity(
            title = "Doa Masuk Masjid",
            arabic = "اللَّهُمَّ افْتَحْ لِي أَبْوَابَ رَحْمَتِكَ",
            latin = "Allaahummaftah lii abwaaba rahmatik.",
            translation = "Ya Allah, bukakanlah untukku pintu-pintu rahmat-Mu.",
            category = "Rumah & Masjid",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Muslim No. 713"
        ),
        DoaEntity(
            title = "Doa Keluar Masjid",
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ فَضْلِكَ",
            latin = "Allaahumma innii as-aluka min fadhlik.",
            translation = "Ya Allah, sesungguhnya aku memohon keutamaan dan karunia dari-Mu.",
            category = "Rumah & Masjid",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Muslim No. 713"
        ),

        // === 5. MAKAN & MINUM ===
        DoaEntity(
            title = "Doa Sebelum Makan",
            arabic = "بِسْمِ اللَّهِ (أو: اللَّهُمَّ بَارِكْ لَنَا فِيمَا رَزَقْتَنَا وَقِنَا عَذَابَ النَّارِ)",
            latin = "Bismillaah. (Atau: Allaahumma baarik lanaa fiimaa razaqtanaa wa qinaa 'adzaaban-naar).",
            translation = "Dengan nama Allah. (Ya Allah, berkahilah kami dalam rezeki yang telah Engkau karuniakan kepada kami dan lindungilah kami dari siksa api neraka).",
            category = "Makan & Minum",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 3767 & At-Tirmidzi No. 1858"
        ),
        DoaEntity(
            title = "Doa Lupa Membaca Bismillah di Awal Makan",
            arabic = "بِسْمِ اللَّهِ أَوَّلَهُ وَآخِرَهُ",
            latin = "Bismillaahi awwalahuu wa aakhirah.",
            translation = "Dengan nama Allah pada awal dan akhirnya.",
            category = "Makan & Minum",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 3767 & At-Tirmidzi No. 1858"
        ),
        DoaEntity(
            title = "Doa Sesudah Makan",
            arabic = "الْحَمْدُ لِلَّهِ الَّذِي أَطْعَمَنِي هَذَا وَرَزَقَنِيهِ مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّةٍ",
            latin = "Alhamdu lillaahil-ladzii ath'amanii haadzaa wa razaqaniihi min ghayri hawlin minnii wa laa quwwah.",
            translation = "Segala puji bagi Allah yang telah memberi makan ini kepadaku dan merezekikannya kepadaku tanpa daya dan kekuatan dariku.",
            category = "Makan & Minum",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 4023 & At-Tirmidzi No. 3458"
        ),
        DoaEntity(
            title = "Doa Berbuka Puasa",
            arabic = "ذَهَبَ الظَّمَأُ، وَابْتَلَّتِ الْعُرُوقُ، وَثَبَتَ الْأَجْرُ إِنْ شَاءَ اللَّهُ",
            latin = "Dzahabazh-zhama-u wabtallatil 'uruuqu wa tsabatal ajru in syaa-Allaah.",
            translation = "Telah hilang dahaga, telah basah urat-urat, dan telah tetap pahala jika Allah menghendaki.",
            category = "Makan & Minum",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 2357"
        ),

        // === 6. PAGI & PETANG ===
        DoaEntity(
            title = "Sayyidul Istighfar (Pagi & Petang)",
            arabic = "اللَّهُمَّ أَنْتَ رَبِّي لَا إِلَهَ إِلَّا أَنْتَ، خَلَقْتَنِي وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوءُ بِذَنْبِي فَاغْفِرْ لِي فَإِنَّهُ لَا يَغْفِرُ الذُّنُوبَ إِلَّا أَنْتَ",
            latin = "Allaahumma anta rabbii laa ilaaha illaa anta, khalaqtanii wa anaa 'abduka, wa anaa 'alaa 'ahdika wa wa'dika mastatha'tu, a'uudzu bika min syarri maa shana'tu, abuu-u laka bini'matika 'alayya, wa abuu-u bidzanbii faghfir lii fa-innahu laa yaghfirudz-dzunuuba illaa anta.",
            translation = "Ya Allah, Engkau adalah Tuhanku, tiada ilah selain Engkau. Engkau telah menciptakanku dan aku adalah hamba-Mu. Aku senantiasa menepati janji-Mu semampuku. Aku berlindung kepada-Mu dari keburukan yang telah kuperbuat. Aku mengakui nikmat-Mu atasku dan aku mengakui dosaku, maka ampunilah aku karena tiada yang dapat mengampuni dosa selain Engkau.",
            category = "Pagi & Petang",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 6306"
        ),
        DoaEntity(
            title = "Doa Perlindungan Pagi & Petang dari Segala Marabahaya",
            arabic = "بِسْمِ اللَّهِ الَّذِي لَا يَضُرُّ مَعَ اسْمِهِ شَيْءٌ فِي الْأَرْضِ وَلَا فِي السَّمَاءِ وَهُوَ السَّمِيعُ الْعَلِيمُ",
            latin = "Bismillaahil-ladzii laa yadhurru ma'as-mihii syai-un fil ardhi wa laa fis-samaa-i wa huwas-samii'ul 'aliim. (3x)",
            translation = "Dengan nama Allah yang bersama nama-Nya tiada sesuatu pun di bumi maupun di langit dapat membahayakan, dan Dialah Yang Maha Mendengar lagi Maha Mengetahui.",
            category = "Pagi & Petang",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 5088 & At-Tirmidzi No. 3388"
        ),
        DoaEntity(
            title = "Doa Keridhaan Iman (Dibaca 3x Pagi & Petang)",
            arabic = "رَضِيتُ بِاللَّهِ رَبًّا، وَبِالْإِسْلَامِ دِينًا، وَبِمُحَمَّدٍ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ نَبِيًّا",
            latin = "Radhiitu billaahi rabbaa, wa bil Islaami diinaa, wa bi Muhammadin shallallaahu 'alayhi wa sallama nabiyyaa.",
            translation = "Aku ridha Allah sebagai Tuhanku, Islam sebagai agamaku, dan Nabi Muhammad shallallahu 'alaihi wa sallam sebagai Nabiku.",
            category = "Pagi & Petang",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 5072 & At-Tirmidzi No. 3389"
        ),

        // === 7. SAFAR & KENDARAAN ===
        DoaEntity(
            title = "Doa Naik Kendaraan",
            arabic = "سُبْحَانَ الَّذِي سَخَّرَ لَنَا هَذَا وَمَا كُنَّا لَهُ مُقْرِنِينَ وَإِنَّا إِلَى رَبِّنَا لَمُنْقَلِبُونَ",
            latin = "Subhaanal-ladzii sakh-khara lanaa haadzaa wa maa kunnaa lahuu muqriniin, wa innaa ilaa rabbinaa lamunqalibuun.",
            translation = "Maha Suci Allah yang telah menundukkan semua ini bagi kami padahal kami sebelumnya tidak mampu menguasainya, dan sesungguhnya kami akan kembali kepada Tuhan kami.",
            category = "Safar & Kendaraan",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 2602 & At-Tirmidzi No. 3446"
        ),
        DoaEntity(
            title = "Doa Bepergian / Safar",
            arabic = "اللَّهُمَّ إِنَّا نَسْأَلُكَ فِي سَفَرِنَا هَذَا الْبِرَّ وَالتَّقْوَى، وَمِنَ الْعَمَلِ مَا تَرْضَى، اللَّهُمَّ هَوِّنْ عَلَيْنَا سَفَرَنَا هَذَا وَاطْوِ عَنَّا بُعْدَهُ، اللَّهُمَّ أَنْتَ الصَّاحِبُ فِي السَّفَرِ، وَالْخَلِيفَةُ فِي الْأَهْلِ",
            latin = "Allaahumma innaa nas-aluka fii safarinaa haadzal birra wat-taqwaa, wa minal 'amali maa tardhaa. Allaahumma hawwin 'alaynaa safaranaa haadzaa wathwi 'annaa bu'dah. Allaahumma antash-shaahibu fis-safari, wal khaliifatu fil ahli.",
            translation = "Ya Allah, sesungguhnya kami memohon kepada-Mu dalam perjalanan kami ini kebaikan dan ketakwaan, serta amal perbuatan yang Engkau ridhai. Ya Allah, mudahkanlah perjalanan kami ini dan dekatkanlah jaraknya bagi kami. Ya Allah, Engkaulah pendamping dalam perjalanan dan pelindung keluarga yang ditinggalkan.",
            category = "Safar & Kendaraan",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Muslim No. 1342"
        ),
        DoaEntity(
            title = "Doa Masuk Pasar",
            arabic = "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، يُحْيِي وَيُمِيتُ، وَهُوَ حَيٌّ لَا يَمُوتُ، بِيَدِهِ الْخَيْرُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ",
            latin = "Laa ilaaha illallaahu wahdahu laa syariika lah, lahul mulku wa lahul hamdu, yuhyii wa yumiitu, wa huwa hayyun laa yamuut, biyadihil khayr, wa huwa 'alaa kulli syai-in qadiir.",
            translation = "Tiada ilah yang berhak disembah selain Allah semata, tiada sekutu bagi-Nya. Milik-Nya lah segala kerajaan dan segala pujian. Dia Yang Menghidupkan dan Mematikan, dan Dia Maha Hidup tidak pernah mati. Di tangan-Nya lah segala kebaikan, dan Dia Maha Kuasa atas segala sesuatu.",
            category = "Safar & Kendaraan",
            source = "Kitab Hishnul Muslim",
            reference = "HR. At-Tirmidzi No. 3428 & Al-Hakim"
        ),

        // === 8. PERLINDUNGAN, KESULITAN & SAKIT ===
        DoaEntity(
            title = "Doa Menjenguk Orang Sakit",
            arabic = "لَا بَأْسَ طَهُورٌ إِنْ شَاءَ اللَّهُ (أو: أَسْأَلُ اللَّهَ الْعَظِيمَ رَبَّ الْعَرْشِ الْعَظِيمِ أَنْ يَشْفِيَكَ)",
            latin = "Laa ba'-sa thahuurun in syaa-Allaah. (As-alullaahal 'azhiima rabbal 'arsyil 'azhiimi an yasyfiyak - 7x).",
            translation = "Tidak mengapa, semoga sakitmu ini menjadi pembersih dosa-dosa, insya Allah. (Aku memohon kepada Allah Yang Maha Agung, Tuhan pemilik 'Arsy yang agung, agar menyembuhkanmu).",
            category = "Perlindungan & Sakit",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 3616 & At-Tirmidzi No. 2083"
        ),
        DoaEntity(
            title = "Doa Ketika Tertimpa Duka & Kesusahan (Doa Al-Karb)",
            arabic = "لَا إِلَهَ إِلَّا اللَّهُ الْعَظِيمُ الْحَلِيمُ، لَا إِلَهَ إِلَّا اللَّهُ رَبُّ الْعَرْشِ الْعَظِيمِ، لَا إِلَهَ إِلَّا اللَّهُ رَبُّ السَّمَاوَاتِ وَرَبُّ الْأَرْضِ وَرَبُّ الْعَرْشِ الْكَرِيمِ",
            latin = "Laa ilaaha illallaahul 'azhiimul haliim, laa ilaaha illallaahu rabbul 'arsyil 'azhiim, laa ilaaha illallaahu rabbus-samaawaati wa rabbul ardhi wa rabbul 'arsyil kariim.",
            translation = "Tiada ilah yang berhak disembah selain Allah Yang Maha Agung lagi Maha Penyantun. Tiada ilah selain Allah Tuhan Pemilik 'Arsy yang agung. Tiada ilah selain Allah Tuhan langit dan bumi serta Pemilik 'Arsy yang mulia.",
            category = "Perlindungan & Sakit",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 6345 & Muslim No. 2730"
        ),
        DoaEntity(
            title = "Doa Pelunas Hutang & Penghilang Gundah",
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْهَمِّ وَالْحَزَنِ، وَالْعَجْزِ وَالْكَسَلِ، وَالْبُخْلِ وَالْجُبْنِ، وَضَلَعِ الدَّيْنِ وَغَلَبَةِ الرِّجَالِ",
            latin = "Allaahumma innii a'uudzu bika minal hammi wal hazan, wal 'ajzi wal kasal, wal bukhli wal jubn, wa dhala'id-dayni wa ghalabatir-rijaal.",
            translation = "Ya Allah, sesungguhnya aku berlindung kepada-Mu dari rasa gelisah dan sedih, dari kelemahan dan kemalasan, dari sifat kikir dan pengecut, serta dari lilitan hutang dan penindasan orang lain.",
            category = "Perlindungan & Sakit",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 2893"
        ),
        DoaEntity(
            title = "Doa Memohon Keteguhan Hati dalam Agama",
            arabic = "يَا مُقَلِّبَ الْقُلُوبِ ثَبِّتْ قَلْبِي عَلَى دِينِكَ",
            latin = "Yaa muqallibal quluubi tsabbit qalbii 'alaa diinik.",
            translation = "Wahai Dzat Yang Membolak-balikkan hati, teguhkanlah hatiku di atas agama-Mu.",
            category = "Perlindungan & Sakit",
            source = "Kitab Hishnul Muslim",
            reference = "HR. At-Tirmidzi No. 2140"
        ),
        DoaEntity(
            title = "Doa Menghilangkan Kemarahan",
            arabic = "أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ",
            latin = "A'uudzu billaahi minasy-syaithaanir-rajiim.",
            translation = "Aku berlindung kepada Allah dari godaan setan yang terkutuk.",
            category = "Perlindungan & Sakit",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 3282 & Muslim No. 2610"
        ),
        DoaEntity(
            title = "Doa Bersin dan Jawabannya (Tasymit)",
            arabic = "الْحَمْدُ لِلَّهِ (يَرۡحَمُكَ ٱللَّهُ - يَهۡدِيكُمُ ٱللَّهُ وَيُصۡلِحُ بَالَكُمۡ)",
            latin = "Yang bersin: Alhamdulillaah. Yang mendengar menjawab: Yarhamukallaah. Dibalas: Yahdiikumullaahu wa yushlihu baalakum.",
            translation = "Yang bersin: 'Segala puji bagi Allah.' Yang mendengar: 'Semoga Allah merahmatimu.' Dibalas: 'Semoga Allah memberimu petunjuk dan memperbaiki keadaanmu.'",
            category = "Keluarga & Adab",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Bukhari No. 6224"
        ),
        DoaEntity(
            title = "Doa Penutup Pertemuan (Kafaratul Majelis)",
            arabic = "سُبْحَانَكَ اللَّهُمَّ وَبِحَمْدِكَ، أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا أَنْتَ، أَسْتَغْفِرُكَ وَأَتُوبُ إِلَيْكَ",
            latin = "Subhaanakallaahumma wa bihamdika, asyhadu allaa ilaaha illaa anta, astaghfiruka wa atuubu ilayk.",
            translation = "Maha Suci Engkau ya Allah dan dengan memuji-Mu, aku bersaksi bahwa tiada ilah yang berhak disembah selain Engkau, aku memohon ampunan kepada-Mu dan aku bertaubat kepada-Mu.",
            category = "Keluarga & Adab",
            source = "Kitab Hishnul Muslim",
            reference = "HR. Abu Dawud No. 4859 & At-Tirmidzi No. 3433"
        ),
        DoaEntity(
            title = "Doa Sapu Jagad (Kebaikan Dunia & Akhirat)",
            arabic = "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
            latin = "Rabbanaa aatinaa fid-dunyaa hasanatan wa fil aakhirati hasanatan wa qinaa 'adzaaban-naar.",
            translation = "Wahai Tuhan kami, berikanlah kepada kami kebaikan di dunia dan kebaikan di akhirat, serta lindungilah kami dari azab siksa api neraka.",
            category = "Keluarga & Adab",
            source = "Kitab Hishnul Muslim",
            reference = "QS. Al-Baqarah: 201 & HR. Bukhari No. 6389"
        )
    )
}
