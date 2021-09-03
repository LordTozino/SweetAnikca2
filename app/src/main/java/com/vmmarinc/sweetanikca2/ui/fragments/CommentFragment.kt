package com.vmmarinc.sweetanikca2.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vmmarinc.sweetanikca2.ui.adapters.CommentAdapter
import com.vmmarinc.sweetanikca2.ui.listeners.CommentListener
import com.vmmarinc.sweetanikca2.data.models.Comment
import com.vmmarinc.sweetanikca2.databinding.FragmentCommentBinding
import com.vmmarinc.sweetanikca2.ui.viewmodels.CommentViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [CommentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommentFragment : Fragment() {
    // TODO: Rename and change types of

    private var _binding: FragmentCommentBinding? = null
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentManager: LinearLayoutManager
    private val binding get() = _binding!!

    private val commentViewModel: CommentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        commentAdapter = CommentAdapter (
            listOf()

        )

        commentAdapter.listener = object: CommentListener {
            override fun onClick(comment: Comment){
                Log.d("Click", comment.name!!)
            }
        }
        commentManager = LinearLayoutManager(requireContext())
        binding.commentRecycler.apply{
            adapter = commentAdapter
            layoutManager = commentManager
        }

        commentViewModel.loadComments()
        commentViewModel.comment.observe(viewLifecycleOwner, Observer { comments ->
            commentAdapter.newDataset(comments)

        })


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_comment, container, false)
    }


}