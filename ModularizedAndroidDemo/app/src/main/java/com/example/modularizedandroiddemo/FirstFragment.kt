package com.example.modularizedandroiddemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.modularizedandroiddemo.databinding.FragmentFirstBinding
import com.example.modularizedlibrary.Greeting

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


            val greeting = Greeting()
            // WARNING: The app crashes at this point;
            // My theory is that the Greeting class is not able to access the UserProfile class
            // This worked in iOS, but not in Android
            val result = greeting.greet()
            // ideally, I expect the UserProfile class should be accessible here
            val userProfile = UserProfile(
                name = "John Doe",
                age = 30
            )
            // but I'm getting build errors here.
            // Therefore, there's something that I need to adjust on the KMM side
            binding.textviewFirst.text = "meh";
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}