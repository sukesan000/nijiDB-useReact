import { Props } from 'framer-motion/types/types'
import { memo, VFC } from 'react'
import {
  Box,
  Button,
  Editable,
  EditableInput,
  EditablePreview,
  Flex,
} from '@chakra-ui/react'

export const SearchForm: VFC<Props> = memo(() => {
  return (
    <Box p="15px">
      <Flex justify="center">
        <Editable
          borderRadius="full"
          shadow="lg"
          bg="white"
          color="GrayText"
          w="md"
        >
          <EditablePreview borderRadius="full" />
          <EditableInput borderRadius="full" />
        </Editable>
        <Button ml="15px" colorScheme="teal" borderRadius="15px" shadow="lg">
          検索
        </Button>
      </Flex>
    </Box>
  )
})
