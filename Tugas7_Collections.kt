fun main(){
    data class NilaiMahasiswa(
        val nim: String,
        val nama: String,
        val mataKuliah:String,
        val nilai: Int
    )

    val dataMahasiswa = listOf(
        NilaiMahasiswa("F1D02310098", "Yusri Abdi", "Mobile", 90),
        NilaiMahasiswa("F1D02310052", "Fitri Nufa", "PCD", 11),
        NilaiMahasiswa("F1D02310048", "Fadila Rahmania", "ProbStat", 65),
        NilaiMahasiswa("F1D02310123", "Wahyu Hilal", "NLP", 99),
        NilaiMahasiswa("F1D02310114", "Izzat Nazhiefa", "Bhs. Inggris", 65),
        NilaiMahasiswa("F1D02310056", "Baiq Alfia", "Mobile", 88),
        NilaiMahasiswa("F1D02310116", "Rizaldi Kurniawan", "Bhs. Inggris", 80),
        NilaiMahasiswa("F1D02310065", "Fadlullah Hasan", "Big Data", 89),
        NilaiMahasiswa("F1D02310055", "Bayu Aji", "PBO", 95),
        NilaiMahasiswa("F1D02310001", "Miftah Aziz", "Agama", 70),
    )

    fun nilaiKode(nilai: Int): Char {
        return when(nilai){
            in 85..100 -> 'A'
            in 70..84 -> 'B'
            in 60..69 -> 'C'
            in 50..59 -> 'D'
            else -> 'E'
        }
    }

    println()
    println("=================== DATA NILAI MAHASISWA ===================")
    println("------------------------------------------------------------")

    println(String.format("%-4s %-12s %-20s %-15s %-4s",
        "No","NIM","Nama","MataKuliah","Nilai"))

    dataMahasiswa.forEachIndexed { i, m ->
        println(String.format("%-4s %-12s %-20s %-15s %-4s",
            i+1, m.nim, m.nama, m.mataKuliah, m.nilai))
    }

    println()
    println("======================== STATISTIK =========================")
    println("------------------------------------------------------------")
    println("Total Mahasiswa : ${dataMahasiswa.size}")

    val nilaiRata = dataMahasiswa.map{it.nilai}.average()
    println("Rata-rata Nilai : $nilaiRata")

    val nilaiTertinggi = dataMahasiswa.maxByOrNull{it.nilai}
    println("Nilai Tertinggi : ${nilaiTertinggi?.nilai} (${nilaiTertinggi?.nama})")

    val nilaiTerendah = dataMahasiswa.minByOrNull{it.nilai}
    println("Nilai Terendah  : ${nilaiTerendah?.nilai} (${nilaiTerendah?.nama})")

    println()
    println("===================== MAHASISWA LULUS ======================")
    val lulus = dataMahasiswa.filter{it.nilai >= 70}

    println("------------------------ ASCENDING -------------------------")
    val asc = lulus.sortedBy{it.nilai}
    asc.forEach{
        val grade = nilaiKode(it.nilai)
        println(String.format("%-20s %-4s %-4s %-4s",it.nama," - ",it.nilai, "($grade)"))
    }

    println()
    println("----------------------- DESCENDING -------------------------")
    val desc = lulus.sortedByDescending{it.nilai}
    desc.forEach{
        val grade = nilaiKode(it.nilai)
        println(String.format("%-20s %-4s %-4s %-4s",it.nama," - ",it.nilai, "($grade)"))
    }

    println()
    println("================== MAHASISWA TIDAK LULUS ===================")
    val tidakLulus = dataMahasiswa.filter{it.nilai < 70}

    println("------------------------ ASCENDING -------------------------")
    val ascNot = tidakLulus.sortedBy{it.nilai}
    ascNot.forEach{
        val grade = nilaiKode(it.nilai)
        println(String.format("%-20s %-4s %-4s %-4s",it.nama," - ",it.nilai, "($grade)"))
    }

    println()
    println("----------------------- DESCENDING -------------------------")
    val descNot = tidakLulus.sortedByDescending{it.nilai}
    descNot.forEach{
        val grade = nilaiKode(it.nilai)
        println(String.format("%-20s %-4s %-4s %-4s",it.nama," - ",it.nilai, "($grade)"))
    }

    println()
    println("================ KELOMPOK BERDASARKAN GRADE ================")
    println("------------------------------------------------------------")
    val kelompok = dataMahasiswa.groupBy{nilaiKode(it.nilai)}
    val kelompokAsc = kelompok.toSortedMap()
    kelompokAsc.forEach{g, mhs ->
        println("Grade $g:")
        mhs.forEach { println(" - ${it.nama} (${it.nilai})") }
    }

    println()
    println("===================== JUMLAH PER GRADE =====================")
    println("------------------------------------------------------------")
    kelompokAsc.forEach{g, mhs ->
        println("Grade $g: ${mhs.size} Mahasiswa")
    }

    println()
    println("====================== CARI MAHASISWA ======================")
    println("------------------------------------------------------------")
    print("Masukkan Nama Mahasiswa: ")
    val namaCari = readLine()

    val hasil = dataMahasiswa.filter{
        it.nama.contains(namaCari!!, ignoreCase = true)
    }

    hasil.forEach{
        println("${it.nama}")
        println(" - NIM         : ${it.nim}")
        println(" - Mata Kuliah : ${it.mataKuliah}")
        println(" - Nilai       : ${it.nilai}")
        println(" - Grade       : ${nilaiKode(it.nilai)}")
        val status = when(it.nilai){
            in 0..69 -> "Tidak Lulus"
            else -> "Lulus"
        }
        println(" - Status      : $status")
    }
    println()
}