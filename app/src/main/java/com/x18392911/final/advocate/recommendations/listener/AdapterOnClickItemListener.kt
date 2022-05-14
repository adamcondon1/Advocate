package com.x18392911.final.advocate.recommendations.listener

//Listener for maps API
interface AdapterOnClickItemListener<M> {
    fun onItemClicked(position: Int, item: M)
}