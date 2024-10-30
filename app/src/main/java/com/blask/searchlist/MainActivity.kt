package com.blask.searchlist

import StudentAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ RecyclerView và EditText bằng findViewById
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val etSearch = findViewById<EditText>(R.id.etSearch)

        // Khởi tạo danh sách sinh viên
        initStudentList()

        // Cài đặt RecyclerView
        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        // Lắng nghe thay đổi trong EditText để tìm kiếm
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                if (query.length > 2) {
                    filter(query)
                } else {
                    studentAdapter.filterList(studentList)  // Hiển thị toàn bộ danh sách nếu từ khóa < 2 ký tự
                }
            }
        })
    }

    // Hàm để tạo danh sách sinh viên mẫu
    private fun initStudentList() {
        studentList.add(Student("Nguyen Van A", "20180001"))
        studentList.add(Student("Tran Thi B", "20180002"))
        studentList.add(Student("Le Van C", "20180003"))
        studentList.add(Student("Pham Thi D", "20180004"))
        studentList.add(Student("Hoang Anh E", "20180005"))
        studentList.add(Student("Nguyen Thi F", "20180006"))
        studentList.add(Student("Vu Van G", "20180007"))
        studentList.add(Student("Bui Thi H", "20180008"))
        studentList.add(Student("Do Van I", "20180009"))
        studentList.add(Student("Dao Thi J", "20180010"))
        studentList.add(Student("Nguyen Duc Anh", "20215689"))
        studentList.add(Student("Nguyen Van K", "20180011"))
        studentList.add(Student("Tran Van L", "20180012"))
        studentList.add(Student("Le Thi M", "20180013"))
        studentList.add(Student("Pham Van N", "20180014"))
        studentList.add(Student("Hoang Thi O", "20180015"))
        studentList.add(Student("Nguyen Van P", "20180016"))
        studentList.add(Student("Vu Thi Q", "20180017"))
        studentList.add(Student("Bui Van R", "20180018"))
        studentList.add(Student("Do Thi S", "20180019"))
        studentList.add(Student("Dao Van T", "20180020"))
        studentList.add(Student("Pham Quoc Minh","20225687"))
        studentList.add(Student("Nguyen Van U", "20180021"))
        studentList.add(Student("Tran Thi V", "20180022"))
        studentList.add(Student("Le Van W", "20180023"))
        studentList.add(Student("Pham Thi X", "20180024"))
        studentList.add(Student("Hoang Van Y", "20180025"))
        studentList.add(Student("Nguyen Thi Z", "20180026"))
        studentList.add(Student("Vu Van A1", "20180027"))
        studentList.add(Student("Bui Thi B1", "20180028"))
        studentList.add(Student("Do Van C1", "20180029"))
        studentList.add(Student("Dao Thi D1", "20180030"))

        studentList.add(Student("Nguyen Van E1", "20180031"))
        studentList.add(Student("Tran Van F1", "20180032"))
        studentList.add(Student("Le Thi G1", "20180033"))
        studentList.add(Student("Pham Van H1", "20180034"))
        studentList.add(Student("Hoang Thi I1", "20180035"))
        studentList.add(Student("Nguyen Van J1", "20180036"))
    }

    // Hàm lọc danh sách sinh viên theo từ khóa
    private fun filter(query: String) {
        val filteredList = studentList.filter {
            it.name.contains(query, ignoreCase = true) || it.mssv.contains(query)
        }
        studentAdapter.filterList(filteredList)
    }
}
