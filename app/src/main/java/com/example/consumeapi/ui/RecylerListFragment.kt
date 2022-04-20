//package com.example.consumeapi.ui
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.consumeapi.R
//import com.example.consumeapi.adapter.RecylerviewAdapter
//import com.example.consumeapi.models.RecyclerList
//import com.example.consumeapi.viewModel.MainActivityViewModel
//
//
//class RecylerListFragment : Fragment() {
//
//private lateinit var recyclerAdapter: RecylerviewAdapter
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view= inflater.inflate(R.layout.fragment_recyler_list, container, false)
//
//   return view
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        iniViewModel(view)
//        iniViewModel()
//    }
//
//
//
//    private fun iniViewModel(view: View?) {
//       val recylcer= requireView().findViewById<RecyclerView>(R.id.reclerview)
//        recylcer?.layoutManager= LinearLayoutManager(activity)
//        val decortion= DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
//       recylcer?.addItemDecoration(decortion)
//        recyclerAdapter=RecylerviewAdapter()
//        recylcer?.adapter=recyclerAdapter
//
//    }
//    private fun iniViewModel() {
//        val viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        viewModel.makeApiCall()
//        viewModel.getRecylerListObservers().observe(viewLifecycleOwner, Observer<RecyclerList> {
//if(it !=null){
//    recyclerAdapter.setUpdateData(it.items)
//}else{
//    println( "::::::::::errror in getting data")
//}
//        })
//    }
//    companion object {
//
//        @JvmStatic
//        fun newInstance() =
//            RecylerListFragment().apply {
//
//                }
//            }
//    }
