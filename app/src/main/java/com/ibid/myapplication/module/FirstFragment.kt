package com.ibid.myapplication.module

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibid.myapplication.R
import com.ibid.myapplication.databinding.FragmentFirstBinding
import com.ibid.myapplication.module.adapter.MyItemListRecyclerViewAdapter
import com.ibid.myapplication.module.service.DataModule
import com.ibid.myapplication.module.service.ItemList
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("tag", "data : ")

        val apiService = DataModule.create()
        apiService.getItem().enqueue(object : retrofit2.Callback<ItemList> {

            override fun onResponse(call: Call<ItemList>, response: Response<ItemList>) {
                Log.d("status ", response.code().toString())

                if (response.isSuccessful) {
                    val data = response.body()
                    Log.e("tag", "data : ")

                    binding.rvList.adapter = MyItemListRecyclerViewAdapter(data!!.data)
                    binding.rvList.layoutManager = LinearLayoutManager(context)
                } else {
                    Log.e("tag", "errornya ")
                }
            }

            override fun onFailure(call: Call<ItemList>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}