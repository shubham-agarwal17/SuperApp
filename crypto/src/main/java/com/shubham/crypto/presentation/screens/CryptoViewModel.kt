package com.shubham.crypto.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.shubham.utilities.logging.AppLogger
import com.shubham.crypto.domain.model.Coin
import com.shubham.crypto.domain.model.CryptoList
import com.shubham.crypto.domain.repository.CryptoRepository
import kotlinx.coroutines.launch

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val repository : CryptoRepository
) : ViewModel() {

    private val _cryptoList = MutableLiveData<List<CryptoList>>()
    val cryptoList: LiveData<List<CryptoList>> = _cryptoList

    private val _coin = MutableLiveData<Coin>()
    val coin: LiveData<Coin> = _coin

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchWealthList() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _cryptoList.value = repository.getCryptoList()
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
                _coin.value = repository.getCryptoById(coinId)
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