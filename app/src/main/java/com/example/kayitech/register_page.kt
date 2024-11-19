package com.example.kayitech

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [register_page.newInstance] factory method to
 * create an instance of this fragment.
 */
class register_page : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_register_page, container, false)

        val backArrow = view.findViewById<ImageView>(R.id.back_arrow)

        val signInText = view.findViewById<TextView>(R.id.signInText)

        backArrow.setOnClickListener {
            findNavController().navigate(R.id.action_register_page2_to_intro_page)
        }

        signInText.setOnClickListener {
            findNavController().navigate(R.id.action_register_page2_to_login_page)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        // Hide the toolbar
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        // Hide the Floating Action Button
        (activity as? MainActivity)?.binding?.fab?.hide()

        (activity as? MainActivity)?.findViewById<BottomNavigationView>(R.id.bottom_navigation)?.visibility = View.GONE
    }

    // Shows the toolbar and FAB again when leaving this fragment
    override fun onPause() {
        super.onPause()
        // Show the toolbar
        (activity as? AppCompatActivity)?.supportActionBar?.show()

        // Show the Floating Action Button
        (activity as? MainActivity)?.binding?.fab?.show()

        (activity as? MainActivity)?.findViewById<BottomNavigationView>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment register_page.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            register_page().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}