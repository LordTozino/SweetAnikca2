package com.vmmarinc.sweetanikca2.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vmmarinc.sweetanikca2.data.models.Comment
import com.vmmarinc.sweetanikca2.data.models.Product
import com.vmmarinc.sweetanikca2.data.models.StoreInfo
import com.vmmarinc.sweetanikca2.data.repositories.CommentRepository
import com.vmmarinc.sweetanikca2.data.repositories.HomeRepository
import com.vmmarinc.sweetanikca2.data.repositories.ProductRepository
import kotlinx.coroutines.launch
//import org.w3c.dom.Comment

class SplashViewModel(private val repo: CommentRepository,
    private val repoProduct: ProductRepository, private val repoStore: HomeRepository): ViewModel() {
        fun insert(comments: List<Comment>, products: List<Product>, store: StoreInfo){
            viewModelScope.launch {
                repo.insertComments(comments)
                repoProduct.insertProducts(products)
                repoStore.insertStore(store)
            }
        }
}