package com.example.modularizedandroiddemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.modularizedandroiddemo.databinding.FragmentFirstBinding
import com.example.modularizedlibrary.Greeting
import com.example.modularizedlibrary.profile.UserProfile
import coremodule.com.example.modularizedlibrary.core.CoreClass

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

        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)


            // fixed: The fix applied was to include the modules' AARs files when copying
            val userProfile = UserProfile(
                name = "John Washington",
                age = 31
            )
            binding.textviewFirst.text = userProfile.greet();

            val coreClass = CoreClass(name = "George Washington")
            binding.textviewFirst.text = coreClass.greet();
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}