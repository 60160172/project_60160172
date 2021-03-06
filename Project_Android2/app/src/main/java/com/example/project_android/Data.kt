package com.example.project_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class Data : Fragment() {
    private var head : String = ""
    private var body : String = ""
    private var img : String = ""

    fun newInstance(head: String,body: String,img: String): Data{

        val fragment = Data()
        val bundle = Bundle()
        bundle.putString("head", head)
        bundle.putString("body", body)
        bundle.putString("img", img)
        fragment.setArguments(bundle)

        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            head = bundle.getString("head").toString()
            body = bundle.getString("body").toString()
            img = bundle.getString("img").toString()

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data, container, false)
        val imgVi : ImageView = view.findViewById(R.id.imgV)
        val headTxt : TextView = view.findViewById(R.id.tv_name)
        val bodyTxt : TextView = view.findViewById(R.id.a_description)


        headTxt.setText(head)
        bodyTxt.setText(body)
        Glide.with(activity!!.baseContext)
            .load(img)
            .into(imgVi);
        // Inflate the layout for this fragment

        return view
    }




}
