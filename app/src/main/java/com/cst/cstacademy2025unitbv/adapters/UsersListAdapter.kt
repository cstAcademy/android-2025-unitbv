package com.cst.cstacademy2025unitbv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.models.UserModel

class UsersListAdapter(
    private val items: List<UserModel>
): RecyclerView.Adapter<UsersListAdapter.UserViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        items.getOrNull(position)?.let { item ->
            holder.bind(item)
        }
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imvAvatar = itemView.findViewById<ImageView>(R.id.imv_avatar)
        private val tvFullName = itemView.findViewById<TextView>(R.id.tv_full_name)
        private val tvEmail = itemView.findViewById<TextView>(R.id.tv_email)

        fun bind(model: UserModel) {
            val fullName = "${model.firstName} ${model.lastName}"
            tvFullName.text = fullName

            tvEmail.text = model.email

            Glide
                .with(itemView.context)
                .load(model.avatar)
                .into(imvAvatar)
        }
    }
}