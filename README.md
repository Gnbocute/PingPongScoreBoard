  Abordagem	                  |  Rotação de Tela	|   Morte do Processo
 remember	                  |  Não sobrevive	    |   Não sobrevive
 ViewModel + mutableStateOf	  |  Sobrevive	        |   Não sobrevive
 ViewModel + StateFlow	      |  Sobrevive	        |   Não sobrevive
 ViewModel + SavedStateHandle |	 Sobrevive	        |   Sobrevive
  
1- O ViewModel é mantido na memória RAM enquanto a instância da Activity está viva ou passando por mudanças de 
configuração (como rotação). Porém, quando o SO mata o processo para liberar memória,
toda a memória RAM alocada para o app — incluindo o ViewModel — é destruída. 
Apenas o mecanismo de estado salvo do sistema (SavedStateHandle / Bundle) persiste esses dados em disco
para reidratar o processo reconstruído.

2- Nenhuma diferença visual ou funcional nesta aplicação. O mutableStateOf é nativo do Jetpack 
Compose, enquanto o StateFlow faz parte das Coroutines do Kotlin (independente de UI). 
A diferença é que o StateFlow permite reatividade em camadas de arquitetura onde o Jetpack Compose não 
está presente (como em regras de negócio no Domain/Data Layer). Nos testes de rotação/morte de processo 
dessa aplicação, essa diferença não foi perceptível, porque o que determina a sobrevivência não é o tipo 
de estado usado, e sim onde ele é guardado (memória vs. armazenamento persistido pelo sistema, 
como o Bundle do SavedStateHandle).

3- Todas as 4 abordagens seriam insuficientes, pois mantêm dados apenas na memória temporária ou 
no estado temporário de restauração do SO. Para persistência permanente, seria necessário adicionar 
uma solução de armazenamento local duradouro como Room Database ou DataStore/SharedPreferences.

4- A abordagem da Etapa 4 (ViewModel + SavedStateHandle). Ela combina a flexibilidade do StateFlow para 
fluxos assíncronos e arquitetura reativa com a resiliência do SavedStateHandle, garantindo que o usuário 
não perca o placar da partida caso minimize o app e o sistema encerre a Activity por falta de memória.