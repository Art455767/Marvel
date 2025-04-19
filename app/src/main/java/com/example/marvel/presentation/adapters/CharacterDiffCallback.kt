package com.example.marvel.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.domain.models.Character

class CharacterDiffCallback(
    private val oldList: List<Character>,
    private val newList: List<Character>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name &&
                oldList[oldItemPosition].description == newList[newItemPosition].description
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
