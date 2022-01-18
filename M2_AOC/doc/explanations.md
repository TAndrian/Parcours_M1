# Explications sur les exemples de code AOC

## DelayedHello

Cet exemple a pour but de mettre en évidence l'effet
de nombre de threads sur l'exécution de code asynchrone.
Il n'utilise pas (volontairement) ScheduledExecutorService
mais emploie sleep dans le corps des method invocation pour
« occuper » un thread suffisamment de temps pour gêner
les autres _method invocation_.

L'exemple illustre les rôles du pattern Active Object :

- Client -> DelayedHello
- Service -> rien, car DelayedHello emploie directement Scheduler
- 
