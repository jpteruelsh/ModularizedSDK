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
            // also important information:
            // while the `greeting.greet()` worked in iOS,
            // the UserProfile class was not accessible in iOS as well
            val userProfile = UserProfile(
                name = "John Washington",
                age = 31
            )
            // but I'm getting build errors here.
            // Therefore, there's something that I need to adjust on the KMM side

            // additional info: in KMM, I commented the UserProfile class instantiation
            //   in the Greeting class, and the app worked fine here.
            // Therefore, I'm guessing that the UserProfile class is not accessible in the Greeting class
            //   through android implementation;
            //   whereas weirdly enough, it worked in iOS
            binding.textviewFirst.text = userProfile.greet();
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}