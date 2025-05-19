package com.shubham.wealth.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.shubham.utilities.logging.AppLogger
import com.shubham.wealth.domain.model.Coin
import com.shubham.wealth.domain.model.CoinList
import com.shubham.wealth.domain.repository.WealthRepository
import kotlinx.coroutines.launch

@HiltViewModel
class WealthViewModel @Inject constructor(
    private val repository : WealthRepository
) : ViewModel() {

    private val _cryptoList = MutableLiveData<List<CoinList>>()
    val cryptoList: LiveData<List<CoinList>> = _cryptoList

    private val _coin = MutableLiveData<Coin>()
    val coin: LiveData<Coin> = _coin

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchWealthList() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _cryptoList.value = repository.getWealthList()
            }
            catch (e :  Exception) {
                AppLogger.e(message = e.message.toString())
            }
            finally {
                _isLoading.value = false
            }
        }
    }

    fun loadWealthDetails(coinId : String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _coin.value = repository.getWealthById(coinId)
            }
            catch (e :  Exception) {
                AppLogger.e(message = e.message.toString())
            }
            finally {
                _isLoading.value = false
            }
        }
    }
}