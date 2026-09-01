package br.edu.ifsp.scl.sc3046664.pingpongscoreboard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PingPongViewModel : ViewModel() {
    private val _player1Score = MutableStateFlow(0)
    val player1Score: StateFlow<Int> = _player1Score.asStateFlow()

    private val _player2Score = MutableStateFlow(0)
    val player2Score: StateFlow<Int> = _player2Score.asStateFlow()

    private val _player1Name = MutableStateFlow("Player 1")
    val player1Name: StateFlow<String> = _player1Name.asStateFlow()

    private val _player2Name = MutableStateFlow("Player 2")
    val player2Name: StateFlow<String> = _player2Name.asStateFlow()

    fun incrementPlayer1() {
        _player1Score.value++
    }

    fun incrementPlayer2() {
        _player2Score.value++
    }

    fun updatePlayer1Name(name: String) {
        _player1Name.value = name
    }

    fun updatePlayer2Name(name: String) {
        _player2Name.value = name
    }

    fun reset() {
        _player1Score.value = 0
        _player2Score.value = 0
    }
}