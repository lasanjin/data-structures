import           Quicksort
import           System.Random (randomRIO)

main :: IO ()
main = do
    putStrLn "Enter length of random int[]:"
    s          <- getLine
    let n      =  read s :: Int
    ls         <- randList n
    let sorted =  quicksort ls
    putStrLn $ "\nUnsorted:\n" ++ show ls
    putStrLn $ "\nSorted:\n"   ++ show sorted

randList :: (Eq t, Num t) => t -> IO [Int]
randList 0 = return []
randList n = do
    r  <- randomRIO (1,100::Int)
    rs <- randList (n-1)
    return (r:rs)
