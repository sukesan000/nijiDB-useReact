import { Box, Flex, Image, Stack, Text } from '@chakra-ui/react'
import { memo, VFC } from 'react'
import { faUsers } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

type Props = {
  name: string
  imageUrl: string
  subscriber: string
}
export const MemberCard: VFC<Props> = memo((props) => {
  const { name, imageUrl, subscriber } = props
  const iconStyle = {
    marginTop: '2.5px',
  }

  return (
    <Box p={4} w="200px" h="300px" bg="white" borderRadius="10px" shadow="md">
      <Stack textAlign="center">
        <Image
          boxSize="160px"
          borderRadius="full"
          m="auto"
          shadow="lg"
          src={imageUrl}
        />
        <Text color="gray.700" fontWeight="bold" pt="5">
          {name}
        </Text>
        <Flex justifyContent="center">
          <FontAwesomeIcon style={iconStyle} icon={faUsers}></FontAwesomeIcon>
          <Text ml={3} color="gray.600">
            {subscriber}
          </Text>
        </Flex>
      </Stack>
    </Box>
  )
})
