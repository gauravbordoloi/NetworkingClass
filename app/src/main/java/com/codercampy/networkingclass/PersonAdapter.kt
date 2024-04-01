package com.codercampy.networkingclass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codercampy.networkingclass.databinding.ItemPersonBinding

class PersonAdapter(val items: List<User>) : RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = items[position]
        holder.binding.tvName.text = "Name - ${person.id}"
        holder.binding.tvLanguage.text = "Language - ${person.title}"
        holder.binding.tvId.text = "Id - ${person.completed}"
        holder.binding.tvBio.text = "Bio - ${person.userId}"
//        holder.binding.tvVersion.text = "Version - ${person.appVersion.toString()}"
    }
}

class PersonViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root)