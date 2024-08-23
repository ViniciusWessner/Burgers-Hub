package com.example.burgershub.presenter.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgershub.databinding.BurgerItemBinding
import com.example.burgershub.databinding.IngredientItemBinding
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.domain.model.Ingredient
import com.example.burgershub.util.formattedValue
import com.squareup.picasso.Picasso

class IngredientsAdapter(
    private val ingredients: List<Ingredient>,

): RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            IngredientItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = ingredients.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ingredient = ingredients[position]

        holder.binding.textName.text = ingredient.name

        try {
            Picasso
                .get()
                .load(ingredient.img)
                .into(holder.binding.imageBurger)
        }catch (ex: Exception){
            ex.printStackTrace()
        }

    }

    inner class MyViewHolder(val binding: IngredientItemBinding): RecyclerView.ViewHolder(binding.root)

}