package com.odiepriye.mymobilegame

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.odiepriye.mymobilegame.databinding.FragmentSecondBlankBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondBlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondBlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentSecondBlankBinding
    private lateinit var navController: NavController

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
        //return inflater.inflate(R.layout.fragment_second_blank, container, false)
        binding=FragmentSecondBlankBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.nextButton2.setOnClickListener{
            navController.navigate(R.id.action_secondBlankFragment_to_thirdBlankFragment)
        }
        binding.backButton1.setOnClickListener{
            navController.navigate(R.id.action_secondBlankFragment_to_firstBlankFragment)
        }

        //creating media player objects
        val flyMP = MediaPlayer.create(requireActivity(),R.raw.fly)
        val frogMP = MediaPlayer.create(requireActivity(),R.raw.frogs)
        val snakeMP = MediaPlayer.create(requireActivity(),R.raw.snake)
        binding.hiddenImage1.setOnClickListener{
            flyMP.start()
        }
        binding.hiddenImage2.setOnClickListener{
            frogMP.start()
        }
        binding.hiddenImage3.setOnClickListener{
            snakeMP.start()
        }

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondBlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}