package com.x18392911.final.advocate.recommendations.Cart

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.x18392911.final.advocate.recommendations.R
import com.x18392911.final.advocate.recommendations.data.DummyProductData.FAKE_NETWORK_DELAY
import com.x18392911.final.advocate.recommendations.data.Product
import com.x18392911.final.advocate.recommendations.data.source.ProductDataSource
import com.x18392911.final.advocate.recommendations.ui.adapter.ProductListAdapter
import com.x18392911.final.advocate.recommendations.utils.EspressoIdlingResource
import com.x18392911.final.advocate.recommendations.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_product_list.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductListFragment(
    private val productDataSource: ProductDataSource
) : Fragment(),
    ProductListAdapter.Interaction
{
    //allowing movie product tp be added
    override fun onItemSelected(position: Int, item: Product) {
        activity?.run {
            val bundle = Bundle()
            bundle.putInt("product_id", item.id)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProductDetailFragment::class.java, bundle)
                .addToBackStack("ProductDetailFragment")
                .commit()
        }
    }

    lateinit var listAdapter: ProductListAdapter
    lateinit var uiCommunicationListener: UICommunicationListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getData()
    }

    private fun getData(){
        EspressoIdlingResource.increment()
        uiCommunicationListener.loading(true)
        val job = GlobalScope.launch(IO) {
            delay(FAKE_NETWORK_DELAY)
        }
        job.invokeOnCompletion{
            GlobalScope.launch(Main){
                EspressoIdlingResource.decrement()
                uiCommunicationListener.loading(false)
                listAdapter.submitList(productDataSource.getProducts())
            }
        }
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            removeItemDecoration(TopSpacingItemDecoration(30))
            addItemDecoration(TopSpacingItemDecoration(30))
            listAdapter = ProductListAdapter(this@ProductListFragment)
            adapter = listAdapter
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            uiCommunicationListener = context as UICommunicationListener
        }catch (e: ClassCastException){
            Log.e("ProductListFragment", "Must implement interface in $activity: ${e.message}")
        }
    }
}