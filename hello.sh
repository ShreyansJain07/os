# echo "enter first name"
# read first
# echo "last name"
# read last
# echo "your name is: $first $last"

# echo "hello $user"
# echo "this machine is `uname -n`"
# echo "calendar"
# cal
# echo "you are running processes"
# ps

# read -p "enter income amt" inc
# read -p "enter expenditure amt" exp
# let net=$inc-$exp
# if [ "$net" -eq "0" ];
# then
# echo "equal"
# elif [ "$net" -gt "0" ];
# then
# echo "profit of $net"
# else
# echo "loss of $net"
# fi

# count=1
# while [ $count -le 5 ]
# do
# echo "$count"
# ((count++))
# done

# for (( c=5; c>0; c--))
# do
# echo $c
# done

# nums=(1 2 3 4 5)
# len=${#nums[@]}
# for (( i=len-1; i>=0; i-- ))
# do
#   echo ${nums[i]}
# done

# echo "enter num 1 "
# read a
# echo "ente num 2 "
# read b
# sum=$((a+b))
# echo sun is $sum

# echo "enter the num"
# read num
# n=$(($num % 2))
# if [ $n -eq 0 ];
# then
# echo "even"
# else 
# echo odd
# fi

# echo "enter the n"
# read n
# s=0
# for(( i=1; i<=n; i++))
# do
# s=$((s+i))
# done
# echo $s

# for k in a*
# do
# echo "filename $k"
# cat $k
# done

# echo "enter number"
# read n
# f=1
# for ((i=1;i<=n;i++))
# do
# f=$((f*i))
# done
# echo $f

# function entry()
# {
#    echo "Enter Username" 
#    read username
#    echo "Enter password"
#    read password
# }

# entry
# if [[ ( $username == "admin" && $password == "secret" ) ]];
# then
#    echo "valid user" 
# else
#    echo "invalid user"
# fi

# echo "enter the num "
# read n
# s=0
# num=$n
# while [ $n -gt 0 ]
# do
# i=$((n%10))
# s=$((i*i*i+s))
# n=$((n/10))
# done
# if [ $s -eq $num ];
# then
# echo "armstrong"
# else
# echo "no armstrong"
# fi

# echo "enter the num to check for palin"
# read n
# num=$n
# r=0
# while [ $n -gt 0 ]
# do
# d=$((n%10))
# r=$((10*r+d))
# n=$((n/10))
# done
# if [ $r -eq $num ]
# then
# echo "Palindrome"
# else 
# echo "no palin"
# fi

# echo "enter the n"
# read n
# e=0
# o=0
# for (( i=1; i<=n; i++ ))
# do
# if [ $((i%2)) -eq 0 ]
# then
# e=$((e+i))
# else
# o=$((o+i))
# fi
# done
# echo "The even sum is " $e
# echo "The odd sum is " $o

# echo "enter num 1 "
# read x
# echo "ente num 2 "
# read y
# i=1
# r=$x
# while [ $i -lt $y ]
# do
# r=$((r*x))
# i=$((i + 1))
# done
# echo $r

# echo "type smthing noobie"
# read noobie
# echo $noobie
# cat test.txt MFT.java > newfile
# sort test.txt
# sort -r test.txt

# num="6 1 4 2 8 3"
echo "enter array"
read num
max=0
min=100
for n in $num
do
if [ $n -lt $min ];
then
min=$n
elif [ $n -gt $max ];
then
max=$n
fi
done
echo "Maximum " $max
echo "Minimum " $min
