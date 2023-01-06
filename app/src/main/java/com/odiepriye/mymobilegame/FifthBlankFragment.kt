package com.odiepriye.mymobilegame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.odiepriye.mymobilegame.databinding.FragmentFifthBlankBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [FifthBlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FifthBlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentFifthBlankBinding
    private lateinit var navController: NavController
//    lateinit var myLevelModel : MyLevelModel
//    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fifth_blank, container, false)
        binding=FragmentFifthBlankBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.restartButton.setOnClickListener{
            navController.navigate(R.id.action_fifthBlankFragment_to_firstBlankFragment)
        }

//        myLevelModel = ViewModelProvider(requireActivity()).get(myLevelModel::class.java)
//        var levelsList=myLevelModel.myLiveModel.value
//
//        binding.myRecyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
//
//        if(levelsList!=null)
//        {
//            val level = levelsList.level
//            listAdapter = ListAdapter(level)
//            binding.myRecyclerView.adapter=listAdapter
//        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FifthBlankFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FifthBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}