# Arahku - Panduan Ibadah & Falak Modern
**Program Studi Tadris Fisika | Fakultas Ilmu Tarbiyah dan Keguruan**  
**Universitas Islam Negeri (UIN) Syarif Hidayatullah Jakarta**

Aplikasi ibadah multifungsi berbasis hisab astronomis dan fiqih shahih yang memadukan keilmuan fisika falak dan tuntunan ibadah praktis.

---

## 🌟 Fitur Utama
1. **Jadwal Shalat Presisi**: Perhitungan hisab astronomis terintegrasi untuk seluruh kota dan kabupaten di Indonesia (WIB, WITA, WIT) dengan hitung mundur waktu shalat berikutnya.
2. **Arah Kiblat (Azimuth Great Circle)**: Kompas digital dan kalkulator sudut kiblat presisi ke Ka'bah Makkah (21.4225° N, 39.8262° E) via koordinat GPS.
3. **Panduan Shalat 5 Waktu Lengkap**: Rujukan resmi **Mozaik Islam Inilah.com**, mencakup syarat wajib & sah, 13 rukun shalat, niat shalat 5 waktu (munfarid, imam, makmum), serta seluruh bacaan gerakan shalat (Arab, Latin, & Terjemahan).
4. **Dzikir & Doa Harian**: Dzikir Pagi, Dzikir Petang, Dzikir Sebelum Tidur dengan tasbih digital klik interaktif, serta Doa Harian dari Kitab Hishnul Muslim.
5. **Buku Teks Astronomi (Bab 1 s/d Bab 12)**: Materi lengkap astronomi umum, tata surya, astrofisika bintang, kosmologi, instrumentasi teleskop, hingga aplikasi fisika falak modern.
6. **Integrasi Android & Web**: Dapat diakses langsung via web browser di Vercel atau dipasang sebagai aplikasi Android native (`com.taufiq.arahku`).

---

## 🚀 Panduan Deploy ke Vercel (Online Web App)

Aplikasi ini sudah dilengkapi dengan konfigurasi `vercel.json` dan aplikasi web responsif modern (`index.html`) sehingga siap di-online-kan secara gratis dalam 1 menit:

### Cara 1: Deploy Melalui GitHub (Rekomendasi)
1. **Push Proyek ke GitHub**:
   - Jika menggunakan AI Studio, klik menu pengaturan / ekspor untuk push ke repository GitHub Anda (atau download ZIP lalu push ke repo GitHub).
2. **Buka Vercel**:
   - Kunjungi [https://vercel.com](https://vercel.com) dan login menggunakan akun GitHub Anda.
3. **Impor Proyek**:
   - Klik tombol **"Add New..."** -> **"Project"**.
   - Pilih repository GitHub proyek **Arahku** Anda.
4. **Deploy**:
   - Framework Preset: Pilih **"Other"** (Vercel otomatis mendeteksi file statis `index.html` dan `vercel.json`).
   - Root Directory: Biarkan default (`./`).
   - Klik **"Deploy"**.
5. **Selesai!**
   - Dalam beberapa detik aplikasi Anda akan online di URL seperti `https://arahku.vercel.app`.

---

## 📱 Publikasi Android (Google Play Console)
- **Application ID:** `com.taufiq.arahku`
- **Version Code:** `2`
- **Version Name:** `2.0`
- **Build Output:** APK / Android App Bundle (.aab) siap diunggah ke Google Play Console.
