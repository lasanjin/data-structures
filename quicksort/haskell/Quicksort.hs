module Quicksort where

quicksort []          = []
quicksort (x:xs)      = quicksort smaller ++ [x] ++ quicksort bigger
    where smaller = [y | y <- xs,  y < x]   -- all elements y from list xs, such that y  < x
          bigger  = [z | z <- xs,  z >= x]  -- all elements z from list xs, such that z >= x
