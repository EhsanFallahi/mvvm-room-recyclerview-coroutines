package com.example.mvvmroom.login

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmroom.R
import com.example.mvvmroom.database.Student
import com.example.mvvmroom.database.StudentDatabase
import com.example.mvvmroom.database.StudentRepository
import com.example.mvvmroom.databinding.LoginFragmentBinding
import com.example.mvvmroom.login.LoginViewModel
import com.example.mvvmroom.login.LoginViewModelFactory


class LoginFragment : Fragment() {

     private lateinit var binding: LoginFragmentBinding
     private lateinit var viewModel: LoginViewModel
     private lateinit var viewModelFactory: LoginViewModelFactory
     private lateinit var userName:Editable
     private lateinit var email:Editable
     private lateinit var password:Editable
     private lateinit var phoneNumber:Editable
     private lateinit var student: Student
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.login_fragment,container,false)
        val application= requireNotNull(this.activity).application
        val studentDao= StudentDatabase.getInstance(application).studentDao
        val studentRepository=StudentRepository(studentDao)
        viewModelFactory= LoginViewModelFactory(studentRepository,application)
        viewModel= ViewModelProvider(this,viewModelFactory).get(LoginViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModelLoginFragment=viewModel

        diplayListStudent()







        return binding.root

    }

    private fun diplayListStudent() {
        viewModel.getAllStudent().observe(viewLifecycleOwner, Observer {
            Log.i("studentList",it.toString())
        })
    }

//    private fun initInformation() {
//        if((binding.textInputUserName.text).toString().trim().isNullOrEmpty()){
//            binding.textInputUserName.error="please enter userName"
//        }else if(!Patterns.EMAIL_ADDRESS.matcher((binding.textInputEmail.text).toString().trim()).matches()){
//              binding.textInputEmail.error="please enter email"
//        }else if ((binding.textInputPassword.text).toString().trim().isNullOrEmpty()){
//            binding.textInputPassword.error="please enter password"
//        }else if (!Patterns.PHONE.matcher((binding.textInputPhoneNumber.text).toString().trim()).matches()){
//            binding.textInputPhoneNumber.error="please enter phoneNumber"
//        }else{
//            student.apply {
//                userName=text_input_userName.text.toString().trim()
//                email=text_input_email.text.toString().trim()
//                password=text_input_password.text.toString().trim()
//                phoneNumber=text_input_phoneNumber.text.toString().trim()
//            }
//            viewModel.submitInformation(student)
//            Toast.makeText(context,"Success Login",Toast.LENGTH_SHORT).show()
//            resetText()
//        }
//    }

//    private fun resetText() {
//        binding.apply {
//            textInputEmail.text=null
//            textInputUserName.text=null
//            textInputPassword.text=null
//            textInputPhoneNumber.text=null
//        }
//    }
//
//    private fun submitLogin() {
//        initInformation()
//    }

}