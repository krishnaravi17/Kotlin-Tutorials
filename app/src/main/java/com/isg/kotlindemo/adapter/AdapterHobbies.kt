package com.isg.kotlindemo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.isg.kotlindemo.R
import com.isg.kotlindemo.model.HobbiesModel
import kotlinx.android.synthetic.main.list_item.view.*

class AdapterHobbies(val context: Context, private val hobbies: List<HobbiesModel>) :
    RecyclerView.Adapter<AdapterHobbies.MyViewHolder>() {

    companion object {
        val TAG: String = AdapterHobbies::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: HobbiesModel? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    // context.showToast(currentHobby!!.title + " Clicked !")
                }
            }

            itemView.imgShare.setOnClickListener {

                currentHobby?.let {
                    val message: String = "My hobby is: " + currentHobby!!.title

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Please select app: "))
                }
            }
        }

        fun setData(hobby: HobbiesModel?, pos: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}
