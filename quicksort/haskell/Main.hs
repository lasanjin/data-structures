import           Quicksort
import           System.Random (randomRIO)

main = do
    putStrLn "Enter length of random int[]:"
    s          <- getLine
    let n      =  read s :: Int
    ls         <- randList n
    putStrLn $ "\nUnsorted:\n" ++ show ls
    let sorted =  quicksort ls
    putStrLn $ "\nSorted:\n" ++ show sorted

randList 0 = return []
randList n = do
    r  <- randomRIO (1,100::Int)
    rs <- randList (n-1)
    return (r:rs)
