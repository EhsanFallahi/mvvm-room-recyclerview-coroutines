package com.example.mvvmroom.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroom.R
import com.example.mvvmroom.database.Student
import com.example.mvvmroom.databinding.ListItemBinding

class StudentListAdapter(private val studentList:List<Student>):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil
            .inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount()=studentList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(studentList[position])
    }
}


class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(student:Student){
        binding.apply {
            tvUserName.text=student.userName
            tvEmail.text=student.email
        }
    }
}