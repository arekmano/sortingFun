import Data.List

selectionSort :: [Integer] -> [Integer]
selectionSort [] = []
selectionSort list = (minimum list) : (selectionSort $ [x | x <- list, not (x == minimum list)])

main = print $ selectionSort [46,234,75,3467,356,357,224,145,6,37,4]
