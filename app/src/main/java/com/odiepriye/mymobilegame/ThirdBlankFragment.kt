package com.odiepriye.mymobilegame

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.odiepriye.mymobilegame.databinding.FragmentSecondBlankBinding
import com.odiepriye.mymobilegame.databinding.FragmentThirdBlankBinding
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [ThirdBlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdBlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentThirdBlankBinding
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
        //return inflater.inflate(R.layout.fragment_third_blank, container, false)
        binding=FragmentThirdBlankBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.nextButton3.setOnClickListener{
            navController.navigate(R.id.action_thirdBlankFragment_to_fourthBlankFragment)
        }
        binding.backButton2.setOnClickListener{
            navController.navigate(R.id.action_thirdBlankFragment_to_secondBlankFragment)
        }

        val catMP = MediaPlayer.create(requireActivity(),R.raw.cat)
        val cowMP = MediaPlayer.create(requireActivity(),R.raw.cow)
        val goatMP = MediaPlayer.create(requireActivity(),R.raw.goat)
        val list = arrayListOf(catMP, cowMP, goatMP)
        val randomNumber = list.shuffled().first()

        binding.soundButton.setOnClickListener{
            randomNumber.start()
        }
        binding.colorButton.setOnClickListener{
            val red = Color.RED
            val blue = Color.BLUE
            val white = Color.WHITE
            val green = Color.GREEN
            val list = arrayListOf(red, blue, white,green)
            val randomNumber = list.shuffled().first()
            binding.view.paint.color = randomNumber
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdBlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}