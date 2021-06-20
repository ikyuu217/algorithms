import sequtils,strutils
import sugar

iterator range(n: int): int =
  for i in 0..<n:
    yield i

proc getLine[T](fun: string -> T): seq[T] =
  stdin.readLine.split.map fun

# input:
#   N: num of items
#   W: capacity of the bag
#   [V]: value of each item 
#   [Wei]: weight of each item
# task:
#   maximize: ...
#   subject to: ...

block main:
  # input
  var
     N,W: int
  (N,W) = getLine(parseInt)
  var V, Wei = newSeq[int](N)
  for i in range(N): 
    (V[i],Wei[i]) = getLine(parseInt)
  
  # solve
  var K = newSeq[int](W+1)
  for w in 1..W:
    for i in range(N):
      if w - Wei[i] >= 0:
        K[w] = max(K[w], K[w-Wei[i]] + V[i])
  
  # output
  K[W].echo
