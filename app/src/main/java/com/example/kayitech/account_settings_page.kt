package com.example.kayitech

import android.os.Bundle
import android.view.HapticFeedbackConstants
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [account_settings_page.newInstance] factory method to
 * create an instance of this fragment.
 */
class account_settings_page : Fragment() {
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

    override fun onResume() {
        super.onResume()
        // Hide the toolbar
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        // Hide the Floating Action Button
        (activity as? MainActivity)?.binding?.fab?.hide()

        (activity as? MainActivity)?.findViewById<BottomNavigationView>(R.id.bottom_navigation)?.visibility = View.VISIBLE


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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account_settings_page, container, false)

        val backArrowAccountSettingsImage = view.findViewById<ImageView>(R.id.backarrowaccountsettings)

        val themeSettingsTile = view.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.themeSettingsTile)

        backArrowAccountSettingsImage.setOnClickListener {
            it.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
            findNavController().navigate(R.id.action_account_settings_page_to_settings_page)
        }

        themeSettingsTile.setOnClickListener {
            it.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
            findNavController().navigate(R.id.action_account_settings_page_to_accessibility_settings)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment account_settings_page.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            account_settings_page().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}