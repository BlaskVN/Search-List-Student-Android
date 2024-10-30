import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blask.searchlist.R
import com.blask.searchlist.Student

class StudentAdapter(private var students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvMSSV: TextView = itemView.findViewById(R.id.tvMSSV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.tvName.text = student.name
        holder.tvMSSV.text = student.mssv
    }

    override fun getItemCount(): Int {
        return students.size
    }

    fun filterList(filteredStudents: List<Student>) {
        students = filteredStudents
        notifyDataSetChanged()
    }
}
