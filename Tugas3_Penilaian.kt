fun main(){
    
    println()
    println("===== SISTEM PENILAIAN MAHASISWA =====")
    println()

    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()

    print("Masukkan Nilai UTS (0-100): ")
    val nilaiUTS = readLine()!!.toInt()
    if (nilaiUTS !in 0..100){
        println("Error: Nilai UTS harus antara 0 - 100")
        return
    }

    print("Masukkan Nilai UAS (0-100): ")
    val nilaiUAS = readLine()!!.toInt()
    if (nilaiUAS !in 0..100){
        println("Error: Nilai UAS harus antara 0 - 100")
        return
    }

    print("Masukkan Nilai Tugas (0-100): ")
    val nilaiTugas = readLine()!!.toInt()
    if (nilaiTugas !in 0..100){
        println("Error: Nilai Tugas harus antara 0 - 100")
        return
    }

    print("Masukkan Banyak Alpa: ")
    val banyakAlpa = readLine()!!.toInt()
    println()

    println("===== HASIL PENILAIAN MAHASISWA =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $nilaiUTS (BOBOT 30%)")
    println("Nilai UAS   : $nilaiUAS (BOBOT 40%)")
    println("Nilai Tugas : $nilaiTugas (BOBOT 30%)")
    println("Banyak Alpa : $banyakAlpa (>5 Tidak Lulus)")
    println("-------------------------------------")

    val nilaiAkhir: Double = (nilaiUTS * 0.3) + (nilaiUAS * 0.4) + (nilaiTugas * 0.3)
    println("Nilai Akhir : $nilaiAkhir")
    
    var grade: Char = when (nilaiAkhir){
                        in 85.0..100.0 -> 'A'
                        in 70.0..84.0 -> 'B'
                        in 60.0..69.0 -> 'C'
                        in 50.0..59.0 -> 'D'
                        else -> 'E'
                    }
    println("Grade       : $grade")

    var ket: String = when (nilaiAkhir){
                        in 85.0..100.0 -> "Sangat Baik"
                        in 70.0..84.0 -> "Baik"
                        in 60.0..69.0 -> "Cukup"
                        in 50.0..59.0 -> "Kurang"
                        else -> "Sangat Kurang"
                    }
    println("Keterangan  : $ket")

    var status: String = when (nilaiAkhir.toInt()){
                            in 60..100 -> when (banyakAlpa){
                                            in 0..5 -> "Lulus"
                                            else -> "Tidak Lulus (Alpa > 5)"
                                            }
                        else -> "Tidak Lulus"
                    }
    println("Status      : $status")
    println()

    var ucapan: String = when (status){
                            "Lulus" -> "Selamat!!! Anda dinyatakan Lulus"
                            "Tidak Lulus" -> "Maaf!!! Anda belum Lulus"
                            else -> "Maaf!!! Nilai Anda cukup bagus tapi Alpa > 5"
                        }
    println(ucapan)
}