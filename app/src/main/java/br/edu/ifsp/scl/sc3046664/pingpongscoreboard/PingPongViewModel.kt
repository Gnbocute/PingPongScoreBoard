package br.edu.ifsp.scl.sc3046664.pingpongscoreboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class PingPongViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val player1Score: StateFlow<Int> =
        savedStateHandle.getStateFlow(KEY_PLAYER1_SCORE, 0)
    val player2Score: StateFlow<Int> =
        savedStateHandle.getStateFlow(KEY_PLAYER2_SCORE, 0)

    val player1Name: StateFlow<String> =
        savedStateHandle.getStateFlow(KEY_PLAYER1_NAME, "Player 1")
    val player2Name: StateFlow<String> =
        savedStateHandle.getStateFlow(KEY_PLAYER2_NAME, "Player 2")

    fun incrementPlayer1() {
        savedStateHandle[KEY_PLAYER1_SCORE] = player1Score.value + 1
    }

    fun incrementPlayer2() {
        savedStateHandle[KEY_PLAYER2_SCORE] = player2Score.value + 1
    }

    fun updatePlayer1Name(name: String) {
        savedStateHandle[KEY_PLAYER1_NAME] = name
    }

    fun updatePlayer2Name(name: String) {
        savedStateHandle[KEY_PLAYER2_NAME] = name
    }

    fun reset() {
        savedStateHandle[KEY_PLAYER1_SCORE] = 0
        savedStateHandle[KEY_PLAYER2_SCORE] = 0
    }

    companion object {
        private const val KEY_PLAYER1_SCORE = "player1Score"
        private const val KEY_PLAYER2_SCORE = "player2Score"
        private const val KEY_PLAYER1_NAME = "player1Name"
        private const val KEY_PLAYER2_NAME = "player2Name"
    }
}