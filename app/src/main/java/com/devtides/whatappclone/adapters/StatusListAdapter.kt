package com.devtides.whatappclone.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.devtides.whatappclone.R
import com.devtides.whatappclone.listeners.StatusItemClickListener
import com.devtides.whatappclone.util.StatusListElement
import com.devtides.whatappclone.util.populateImage

class StatusListAdapter(val statusList: ArrayList<StatusListElement>): RecyclerView.Adapter<StatusListAdapter.StatusListViewHolder>() {

    private var clickListener: StatusItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = StatusListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_status_list, parent, false)
    )

    fun onRefresh() {
        statusList.clear()
        notifyDataSetChanged()
    }

    fun addElement(element: StatusListElement) {
        statusList.add(element)
        notifyDataSetChanged()
    }

    override fun getItemCount() = statusList.size

    override fun onBindViewHolder(holder: StatusListViewHolder, position: Int) {
        holder.bind(statusList[position], clickListener)
    }

    fun setOnItemClickListener(listener: StatusItemClickListener) {
        clickListener = listener
        notifyDataSetChanged()
    }

    class StatusListViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private var layout = view.findViewById<RelativeLayout>(R.id.itemLayout)
        private var elementIV = view.findViewById<ImageView>(R.id.itemIV)
        private var elementNameTV = view.findViewById<TextView>(R.id.itemNameTV)
        private var elementTimeTV = view.findViewById<TextView>(R.id.itemTimeTV)

        fun bind(element: StatusListElement, listener: StatusItemClickListener?) {
            populateImage(elementIV.context, element.userUrl, elementIV, R.drawable.default_user)
            elementNameTV.text = element.userName
            elementTimeTV.text = element.statusTime
            layout?.setOnClickListener {listener?.onItemClicked(element)}
        }
    }
}