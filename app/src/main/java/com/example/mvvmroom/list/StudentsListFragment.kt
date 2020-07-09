package com.example.mvvmroomrecyclerviewex.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmroom.R

class StudentsListFragment : Fragment() {

    companion object {
        fun newInstance() =
            StudentsListFragment()
    }

    private lateinit var viewModel: StudentsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.students_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StudentsListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}