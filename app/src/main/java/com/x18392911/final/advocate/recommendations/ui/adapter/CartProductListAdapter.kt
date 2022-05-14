package com.x18392911.final.advocate.recommendations.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.data.Product
import com.bumptech.glide.Glide
import com.x18392911.final.advocate.recommendations.R
import com.x18392911.final.advocate.recommendations.utils.EspressoIdlingResource
import kotlinx.android.synthetic.main.fragment_product_detail.view.*

//cart to save users wishlist of movie products
class CartProductListAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_product_list_cart_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Product>) {
        EspressoIdlingResource.increment()
        val dataCommitCallback = Runnable {
            EspressoIdlingResource.decrement()
        }
        differ.submitList(list, dataCommitCallback)
    }

    class ProductViewHolder
    constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Product) = with(itemView) {
            textViewProductName.text = item.productName
            Glide.with(itemView)
            textViewPrice.text = "Rs. ${item.price.toString()}"
            textViewQuantity.text = "Quantity: ${item.rating.toString()}"
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Product)
    }
}
