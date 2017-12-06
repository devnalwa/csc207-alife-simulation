# alife-simulation-dev-kohei

In this experiment, there is 1 cooperator and 9 defectors creating a
population of 10. The cycle runs 100 times. Our prediction is that by the
end of the 100 cycles, the mean cooperation probability will be 0 because
after 10 updates, each of the 9 defectors have 10 energy units and as the
number of updates increase, the defectors try to replace the 1 cooperator
which becomes easier and easier as the number of updates increases. After
running this experiment, we found the mean cooperation probability for each
of the 10 repitions to be 0 making the average of the mean cooperation
probabilty 0 thus proving our hypothesis.


In this experiment, there are 9 cooperators and 1 defector creating a
population of 10. The cycle runs 100 times. Our prediction is that by the
end of the 100 cycles, the mean cooperation probability will be 1 because
after 10 updates, each of the 9 cooperators will have 10 energy units and as the
number of updates increase, the cooperators will try to replace the 1 defector
which becomes easier and easier as the number of updates increases. After
running this experiment, we found the mean cooperation probability for the
10 repitions to be 1,1,0,1,1,0,1,1,1,1, respectively, making the average of
the mean cooperation probabilty 0.8. This was not the result we predicted
and we think this came to be the result because in most cases, the
cooperators try to replace the one defector. However, once the ratio of
cooperators and defectors gets 1 to 1, which is low probability, the result
will be only defectors. We confirmed this by running "ALifeSim 100 50 50 0"
10 times.


In this next experiment, there are 3 cooperators, 3 defectors and 3
partials. The cycle runs a 100 times. Our prediction is that most of the
results the mean cooperation probability will be 0, leaving us with 9
defectors and 0 cooperators and 0 partials. We also believe that some of
the results will give a mean cooperation proability of 0.5 with 0
cooperators, 0 defectors and 9 partials. We believe this will happen
because the 3 cooperators will always give their energy away as the updates
increase and since the partials have a 50% chance of giving their energy
away, they will do so to givng it all to the defectors leaving us with 9
defectors and 0 of the rest. We also said that some will be 0.5 because of
the 50% chance of partials giving their enrgy away which will mean in some
cases they will not do so and will keep reproducing and taking over the
other leaving us with 9 partials and 0 for the rest. Our results were in
agreement to our hypotheis. The results for the 10 repitions were as
follows,0,0,0.5,0,0.5,0,0.5,0,0,0, respectively, making the average of the
mean cooperation probability 0.15.  

In this experiment, there is 1 cooperator and 99 defectors creating a
population of 100. The cycle runs 100 times. Our prediction is that by the
end of the 100 cycles, the mean cooperation probability will be 0 because
after 10 updates, each of the 99 defectors have 10 energy units and as the
number of updates increase, the defectors try to replace the 1 cooperator
which becomes easier and easier as the number of updates increases. After
running this experiment, we found the mean cooperation probability for each
of the 10 repitions to be 0 making the average of the mean cooperation
probabilty 0 thus proving our hypothesis.

In this experiment, there are 99 cooperators and 1 defector creating a
population of 100. The cycle runs 100 times. Our prediction is that by the
end of the 100 cycles, the mean cooperation probability will be 1 because
after 10 updates, each of the 99 cooperators will have 10 energy units and
as the number of updates increase, the cooperators will try to replace the
1 defector which becomes easier and easier as the number of updates
increases. After running this experiment, we found the mean cooperation
probability for the 10 repitions to be 1,1,0.35,1,1,0.71,1,0,1,1, respectively,
makingthe average of the mean cooperation probabilty 0.806. This was not
the result we predicted and we think this came to be the result because in
most cases, the cooperators try to replace the one defector. However, once
the ratio of cooperators and defectors gets 1 to 1, which is low
probability, the result will be only defectors. We confirmed this by
running "ALifeSim 100 50 50 0" 10 times.
